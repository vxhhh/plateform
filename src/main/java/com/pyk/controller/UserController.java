package com.pyk.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pyk.entity.User;
import com.pyk.entity.UserAddress;
import com.pyk.exception.PlateFormException;
import com.pyk.form.UserLoginForm;
import com.pyk.form.UserRegisterForm;
import com.pyk.result.ResponseEnum;
import com.pyk.service.CartService;
import com.pyk.service.OrdersService;
import com.pyk.service.UserAddressService;
import com.pyk.service.UserService;
import com.pyk.utils.RegexValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2022-03-18
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserAddressService userAddressService;

    /**
     * 用户注册
     * @param userRegisterForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/register")
    public String register(@Valid UserRegisterForm userRegisterForm,
                           BindingResult bindingResult){
        //校验结果放在BindingResult
        //非空校验
        if (bindingResult.hasErrors()){
            log.info("【用户注册】用户信息不能为空");
            throw new PlateFormException(ResponseEnum.USER_INFO_NULL);
        }

        User register = this.userService.register(userRegisterForm);
        if (register == null){
            log.info("【用户注册】添加用户失败");
            throw new PlateFormException(ResponseEnum.USER_REGISTER_ERROR);
        }

        return "redirect:/login";
    }


    @PostMapping("/login")
    public String login(@Valid UserLoginForm userLoginForm,
                        BindingResult bindingResult,
                        HttpSession session){
        //非空校验
        if (bindingResult.hasErrors()){
            log.info("【用户登录】用户信息不能为空");
            throw new PlateFormException(ResponseEnum.USER_INFO_NULL);
        }

        User login = this.userService.login(userLoginForm);
        session.setAttribute("user",login);
        return  "redirect:/productCategory/main";
    }

    /**
     * 返回当前用户的订单列表
     * @return
     */
    @GetMapping("/orderList")
    public ModelAndView ordersList(HttpSession session){
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if(user == null){
            log.info("【订单】当前为未登录状态");
            throw new PlateFormException(ResponseEnum.NOT_LOGIN);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderList");
        modelAndView.addObject("orderList",this.ordersService.findAllByUserId(user.getId()));
        modelAndView.addObject("cartList", this.cartService.findVOListByUserId(user.getId()));
        return modelAndView;
    }

    /**
     * 返回当前用户的地址列表
     * @return
     */
    @GetMapping("/addressList")
    public ModelAndView addressList(HttpSession session){
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if(user == null){
            log.info("【更新购物车】当前为未登录状态");
            throw new PlateFormException(ResponseEnum.NOT_LOGIN);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userAddressList");
        QueryWrapper<UserAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());
        modelAndView.addObject("addressList", this.userAddressService.list(queryWrapper));
        modelAndView.addObject("cartList", this.cartService.findVOListByUserId(user.getId()));
        return modelAndView;
    }
}

