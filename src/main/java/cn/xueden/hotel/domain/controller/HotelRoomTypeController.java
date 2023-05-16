package cn.xueden.hotel.domain.controller;

import cn.hutool.json.JSONObject;
import cn.xueden.common.api.Result;
import cn.xueden.hotel.domain.entity.HotelRoomType;
import cn.xueden.hotel.domain.service.IHotelRoomTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.houbb.auto.log.annotation.AutoLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称:HotelRoomTypeController
 * 描述:TODO
 * 创建时间:2023/5/9 16:41
 * 创建人: wuxuewei
 */
@Slf4j
@Api(tags="房间类型接口")
@RestController
@RequestMapping("/hotel/roomtype")
public class HotelRoomTypeController {

    @Autowired
    private IHotelRoomTypeService hotelRoomTypeService;

    /**
     *   保存
     *
     * @param hotelRoomType
     * @return
     */
    @AutoLog(description = "房间类型-保存")
    @ApiOperation(value="房间类型-保存", notes="房间类型-保存")
    @PostMapping("/save")
    public Result<?> add(@RequestBody HotelRoomType hotelRoomType){
        QueryWrapper<HotelRoomType> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(HotelRoomType::getTypeSort,hotelRoomType.getTypeSort());
        if(StringUtils.isNotEmpty(hotelRoomType.getId().toString())&&hotelRoomType.getId()!=0){ //更新逻辑
            queryWrapper.lambda().ne(HotelRoomType::getId,hotelRoomType.getId());
            int  count= (int) hotelRoomTypeService.count(queryWrapper);
            if(count>=1){
                return  Result.error("类型序号已存在");
            }
            hotelRoomTypeService.saveOrUpdate(hotelRoomType);
            return  Result.ok("更新成功！");
        }else{ //新增逻辑
            int  count= (int) hotelRoomTypeService.count(queryWrapper);
            if(count>=1){
                return  Result.error("类型序号已存在");
            }
            hotelRoomTypeService.save(hotelRoomType);
            return  Result.ok("保存成功！");
        }
    }
    /**
     *   查询
     *
     * @param hotelRoomType
     * @return
     */
    @AutoLog(description = "房间类型-查询")
    @ApiOperation(value="房间类型-查询", notes="房间类型-查询")
    @GetMapping("/list")
    public Result<?> queryPageList(HotelRoomType hotelRoomType,
                                   @RequestParam(name="pageNo",defaultValue="1") Integer pageNo,
                                   @RequestParam(name="pageSize",defaultValue="10") Integer pageSize,
                                   @RequestParam(name="typeName",required = false) String typeName
                                   ){ //HttpServletRequest req
        QueryWrapper<HotelRoomType> queryWrapper= new QueryWrapper();
        if(StringUtils.isNotEmpty(typeName)){
            queryWrapper.lambda().like(HotelRoomType::getTypeName,typeName);
        }
        queryWrapper.orderByAsc("length(TYPE_SORT),TYPE_SORT");
        Page<HotelRoomType> page=new Page<>(pageNo,pageSize);
        IPage<HotelRoomType> pageList=  hotelRoomTypeService.page(page,queryWrapper);
        return Result.ok(pageList);

    }
    /**
     *   查询
     *
     * @param id
     * @return
     */
    @AutoLog(description = "房间类型详情-查询")
    @ApiOperation(value="房间类型详情-查询", notes="房间类型详情-查询")
    @GetMapping("/info")
    public Result<?> info(@RequestParam(name="id",required=true) int id){
        QueryWrapper<HotelRoomType> queryWrapper=new QueryWrapper<>();
//        queryWrapper.lambda().eq(HotelRoomType::getId,id);
        HotelRoomType hotelRoomType= hotelRoomTypeService.getById(id);
        return Result.ok(hotelRoomType);
    }
    /**
     *   删除
     * @param id
     * @return
     */
    @AutoLog(description = "房间类型-删除")
    @ApiOperation(value="房间类型-删除", notes="房间类型-删除")
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody JSONObject jsonObject){
        if (!jsonObject.containsKey("id")||!StringUtils.isNotBlank(jsonObject.getStr("id"))) {
            return Result.error("id不能为空！");
        }
        if (StringUtils.isNotBlank(jsonObject.getStr("id"))){
            hotelRoomTypeService.removeById(jsonObject.getStr("id"));
        }
//        QueryWrapper<HotelRoomType> queryWrapper=new QueryWrapper<>();
//        queryWrapper.lambda().eq(HotelRoomType::getId,jsonObject.containsKey("id"));
//        hotelRoomTypeService.remove(queryWrapper);
        return Result.ok("删除成功！");
    }


}
