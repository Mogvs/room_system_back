package cn.xueden.hotel.domain.service.impl;

import cn.xueden.hotel.domain.entity.HotelFloor;
import cn.xueden.hotel.domain.mapper.HotelFloorMapper;
import cn.xueden.hotel.domain.service.IHotelFloorServices;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 名称:HotelFloorServicesImpl
 * 描述:TODO
 * 创建时间:2023/5/14 14:30
 * 创建人: wuxuewei
 */
@Service
@Slf4j
public class HotelFloorServicesImpl extends ServiceImpl<HotelFloorMapper,HotelFloor> implements IHotelFloorServices {
}
