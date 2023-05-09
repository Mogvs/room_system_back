package cn.xueden.hotel.domain.controller;

import cn.xueden.common.api.Result;
import cn.xueden.hotel.domain.entity.HotelRoomType;
import cn.xueden.hotel.domain.service.IHotelRoomTypeService;
import com.github.houbb.auto.log.annotation.AutoLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     *   添加
     *
     * @param hotelRoomType
     * @return
     */
    @AutoLog(description = "房间类型-添加")
    @ApiOperation(value="房间类型-添加", notes="房间类型-添加")
    @PostMapping("/add")
    public Result<?> add(@RequestBody HotelRoomType hotelRoomType){
      //  hotelRoomTypeService.save(hotelRoomType);
       return  Result.ok("添加成功！");
    }


}
