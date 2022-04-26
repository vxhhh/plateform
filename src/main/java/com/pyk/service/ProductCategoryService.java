package com.pyk.service;

import com.pyk.entity.Product;
import com.pyk.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pyk.vo.ProductCategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-03-18
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    public List<ProductCategoryVO> buildProductCategoryMenu();
    public List<ProductCategoryVO> findAllProductByCategoryLevelOne();
 }
