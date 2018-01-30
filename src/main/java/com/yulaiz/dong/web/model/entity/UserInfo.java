package com.yulaiz.dong.web.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -5979462630899705904L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("uuid")
    private String uuid;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("token")
    private String registerToken;

    @ApiModelProperty("备注")
    private String remark;
}
