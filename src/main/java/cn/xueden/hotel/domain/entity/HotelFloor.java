package cn.xueden.hotel.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.io.Serializable;

/**
 * 名称:HotelFloor
 * 描述:楼层实体类
 * 创建时间:2023/5/14 13:54
 * 创建人: wuxuewei
 */
@Data
@Table(name="hotel_floor")
@Accessors(chain = true) //链式编程
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="hotel_floor对象", description="楼层对象")
public class HotelFloor implements Serializable {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;

    @Excel(name = "楼层名称", width = 15)
    @ApiModelProperty(value = "楼层名称")
    private String floorName;

    @Excel(name = "房间序号", width = 15)
    @ApiModelProperty(value = "房间序号")
    private  Integer floorSort;


}
