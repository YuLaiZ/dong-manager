package com.yulaiz.dong.web.controller.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/30.
 */
@Data
public class UserLinkReq implements Serializable {

    private static final long serialVersionUID = -5670667257875397990L;

    @ApiModelProperty("备注")
    private String remark;
}
