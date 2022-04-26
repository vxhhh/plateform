package com.pyk.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class UserRegisterForm {
    /** 后台对注册页面的验证*/
    @NotEmpty(message = "登录名不能为空")
    private String loginName;
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotNull(message = "性别不能为空")
    private Integer gender;
    @NotEmpty(message = "邮箱不能为空")
    private String email;
    @NotEmpty(message = "手机号码不能为空")
    private String mobile;
}
