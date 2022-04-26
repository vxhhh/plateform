package com.pyk.service;

import com.pyk.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pyk.form.UserLoginForm;
import com.pyk.form.UserRegisterForm;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-03-18
 */
public interface UserService extends IService<User> {
    public User register(UserRegisterForm userRegisterForm);

    public User login(UserLoginForm userLoginForm);
}
