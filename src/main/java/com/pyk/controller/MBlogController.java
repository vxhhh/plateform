package com.pyk.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pyk.entity.MBlog;
import com.pyk.entity.User;
import com.pyk.mapper.MBlogMapper;
import com.pyk.service.CartService;
import com.pyk.service.MBlogService;
import com.pyk.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-03-28
 */
@Controller
public class MBlogController {

    @Autowired
    MBlogService mBlogService;
    @Autowired
    MBlogMapper mBlogMapper;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductCategoryService productCategoryService;


    //进入学生查找页信息
    @GetMapping("/payInfo")
    public ModelAndView bloglist(Integer currentPage, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 5);
        IPage pageData = mBlogService.page(page, new QueryWrapper<MBlog>().orderByDesc("created"));
        modelAndView.addObject("payInfoList",pageData);
        //封装商品分类菜单
        modelAndView.addObject("list", this.productCategoryService.buildProductCategoryMenu());
        //封装一级分类对应的商品信息
        modelAndView.addObject("levelOneProductList",this.productCategoryService.findAllProductByCategoryLevelOne());
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if(user == null){
            //未登录
            modelAndView.addObject("cartList", new ArrayList<>());
        }else{
            //登录用户
            //查询该用户的购物车记录
            modelAndView.addObject("cartList",this.cartService.findVOListByUserId(user.getId()));
        }
        return modelAndView;
    }


}

