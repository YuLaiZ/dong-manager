package com.yulaiz.dong.web.controller.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class UserLoginReq implements Serializable {

    private static final long serialVersionUID = 7596563034600653083L;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

}
