package cn.xueden.hotel.domain.dto;

import cn.xueden.hotel.domain.entity.HotelRoomType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 名称:roomDto
 * 描述:出参的dto
 * 创建时间:2023/5/9 16:30
 * 创建人: wuxuewei
 */
@ApiModel(value="hotel_room_type对象", description="房间类型对象")
public class roomDto {

     @ApiModelProperty(value = "房间信息列表")
     private List<HotelRoomType> HotelRoomType;
}
