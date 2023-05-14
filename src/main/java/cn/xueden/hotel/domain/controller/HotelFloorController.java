package cn.xueden.hotel.domain.controller;

import cn.xueden.common.api.Result;
import cn.xueden.hotel.domain.entity.HotelFloor;
import cn.xueden.hotel.domain.service.IHotelFloorServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add")
    public Result<?> save(@RequestBody HotelFloor hotelFloor){
        boolean flag=  hotelFloorServices.save(hotelFloor);
        if(flag) {
            return Result.ok("添加成功");
        }
        return Result.error("添加失败");
    }

}
