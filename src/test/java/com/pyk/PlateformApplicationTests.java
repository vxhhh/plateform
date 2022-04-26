package com.pyk;

import com.pyk.service.ProductCategoryService;
import com.pyk.vo.ProductCategoryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PlateformApplicationTests {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    void contextLoads() {
        List <ProductCategoryVO> productCategoryVOList = this.productCategoryService.buildProductCategoryMenu();
        int i = 0;
    }

}
