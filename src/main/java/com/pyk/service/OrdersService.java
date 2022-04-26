package com.pyk.service;

import com.pyk.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pyk.vo.OrdersVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-03-18
 */
public interface OrdersService extends IService<Orders> {
    public List<OrdersVO> findAllByUserId(Integer id);
}
