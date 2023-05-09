package cn.xueden.hotel.domain.vo;

import cn.xueden.hotel.domain.entity.HotelRoomType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 名称:roomVo
 * 描述:入参的vo类
 * 创建时间:2023/5/9 16:28
 * 创建人: wuxuewei
 */
@ApiModel(value="hotel_room_type对象", description="房间类型对象")
public class roomVo {

    @ApiModelProperty(value = "房间信息")
    private HotelRoomType rot;
}
