package cn.xueden.hotel.domain.controller;



import cn.hutool.json.JSONObject;
import cn.xueden.common.api.Result;
import cn.xueden.hotel.domain.entity.HotelFloor;
import cn.xueden.hotel.domain.service.IHotelFloorServices;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 名称:HotelFloorController
 * 描述:楼层信息接口
 * 创建时间:2023/5/14 13:51
 * 创建人: wuxuewei
 */
@Slf4j
@RestController
@RequestMapping("/hotel/floor")
public class HotelFloorController {

   @Autowired
   private IHotelFloorServices hotelFloorServices;

    @PostMapping("/save")
    public Result<?> save(@RequestBody HotelFloor hotelFloor){
        if(StringUtils.isNotBlank(hotelFloor.getId().toString())&& hotelFloor.getId()!=0){ //更新逻辑
            QueryWrapper<HotelFloor> queryWrapper=new QueryWrapper<>();
            queryWrapper.lambda().eq(HotelFloor::getFloorName,hotelFloor.getFloorName()).ne(HotelFloor::getId,hotelFloor.getId())
                    .or().eq(HotelFloor::getFloorSort,hotelFloor.getFloorSort()).ne(HotelFloor::getId,hotelFloor.getId());
            int count= (int) hotelFloorServices.count(queryWrapper);
            if(count>0){
                return Result.error("楼层名称或楼层编号重复、操作失败");
            }
            boolean flag=hotelFloorServices.saveOrUpdate(hotelFloor);
            if(flag){
                return Result.ok("保存成功");
            }else{
                return Result.error("保存失败");
            }
            }else{
            if(StringUtils.isNotBlank(hotelFloor.getFloorName())){
                QueryWrapper<HotelFloor> queryWrapper=new QueryWrapper<>();
                queryWrapper.lambda().eq(HotelFloor::getFloorName,hotelFloor.getFloorName());
                int count= (int) hotelFloorServices.count(queryWrapper);
                if(count>0){
                    return Result.error("楼层名称已存在,操作失败");
                }
            }
            if(StringUtils.isNotBlank(hotelFloor.getFloorSort().toString())){
                QueryWrapper<HotelFloor> queryWrapper=new QueryWrapper<>();
                queryWrapper.lambda().eq(HotelFloor::getFloorSort,hotelFloor.getFloorSort());
                int count= (int) hotelFloorServices.count(queryWrapper);
                if(count>0){
                    return Result.error("楼层编号已存在,操作失败");
                }
            }
            boolean flag= hotelFloorServices.save(hotelFloor);
            if(flag) {
                return Result.ok("保存成功");
            }
            return Result.error("保存失败");
        }
    }

    @GetMapping("/list")
    public  Result<?> floorlist(HotelFloor hotelFloor,
            @RequestParam(name="pageNo",defaultValue = "1") Integer pageNo,
                           @RequestParam(name="pageSize",defaultValue ="10") Integer pageSize,
                           @RequestParam(name="floorName",required = false) String floorName

    ){
        QueryWrapper<HotelFloor> queryWrapper= new QueryWrapper<>();
        if(StringUtils.isNotBlank(floorName)){
            queryWrapper.lambda().like(HotelFloor::getFloorName,floorName);
        }
        queryWrapper.orderByAsc("length(FLOOR_SORT),FLOOR_SORT");
        Page<HotelFloor> page=new Page<>(pageNo,pageSize);
        IPage<HotelFloor> pageList= hotelFloorServices.page(page,queryWrapper);
        return  Result.ok(pageList);
    }
    @PostMapping ("/delete")
    public Result<?> del(@RequestBody JSONObject jsonObject){
        if(!jsonObject.containsKey("id")|| !StringUtils.isNotBlank(jsonObject.getStr("id"))){
            return Result.error("id不能为空");
        }
        hotelFloorServices.removeById(jsonObject.getStr("id"));
        return Result.ok("删除成功");
    }

}
