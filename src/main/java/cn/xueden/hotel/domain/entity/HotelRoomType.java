package cn.xueden.hotel.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * 名称:HotelRoomType
 * 描述:房间类型
 * 创建时间:2023/5/8 12:13
 * 创建人: wuxuewei
 */
@Data
@Table(name="hotel_room_type")
@Accessors(chain = true) //链式编程
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="hotel_room_type对象", description="房间类型对象")
public class HotelRoomType implements Serializable {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;

    @Excel(name = "房间类型名称", width = 15)
    @ApiModelProperty(value = "房间类型名称")
    private String typeName;

    @Excel(name = "房间序号", width = 15)
    @ApiModelProperty(value = "房间序号")
    private  Integer typeSort;

}
