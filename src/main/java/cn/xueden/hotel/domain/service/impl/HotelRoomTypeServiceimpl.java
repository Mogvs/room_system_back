package cn.xueden.hotel.domain.service.impl;

import cn.xueden.hotel.domain.entity.HotelRoomType;
import cn.xueden.hotel.domain.mapper.HotelRoomTypeMapper;
import cn.xueden.hotel.domain.service.IHotelRoomTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 名称:HotelRoomTypeServiceimpl
 * 描述:TODO
 * 创建时间:2023/5/8 18:22
 * 创建人: wuxuewei
 */
@Service
@Transactional(readOnly = true)
public class HotelRoomTypeServiceimpl extends ServiceImpl<HotelRoomTypeMapper,HotelRoomType> implements IHotelRoomTypeService {

}
