package com.pyk.service;

import com.pyk.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-03-18
 */
public interface ProductService extends IService<Product> {
    public List<Product> findAllByTypeAndProductCategory(Integer type,Integer id);

}
