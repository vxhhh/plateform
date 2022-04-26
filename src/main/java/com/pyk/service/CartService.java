package com.pyk.service;

import com.pyk.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pyk.entity.Orders;
import com.pyk.entity.User;
import com.pyk.vo.CartVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-03-18
 */
public interface CartService extends IService<Cart> {
    public Boolean add(Cart cart);
    public List<CartVO> findVOListByUserId(Integer userId);
    public Boolean update(Integer id,Integer quantity,Float cost);
    public Boolean delete(Integer id);
    public Orders commit(String userAddress, String address, String remark, User user);
}
