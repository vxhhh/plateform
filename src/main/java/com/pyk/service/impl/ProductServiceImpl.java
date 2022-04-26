package com.pyk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pyk.entity.Product;
import com.pyk.mapper.ProductMapper;
import com.pyk.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2022-03-18
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAllByTypeAndProductCategory(Integer type, Integer id) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        String column = null;
        switch (type){
            case 1:
                column = "categorylevelone_id";
                break;
            case 2:
                column = "categoryleveltwo_id";
                break;
            case 3:
                column = "categorylevelthree_id";
                break;
        }
        queryWrapper.eq(column,id);
        return this.productMapper.selectList(queryWrapper);
    }
}
