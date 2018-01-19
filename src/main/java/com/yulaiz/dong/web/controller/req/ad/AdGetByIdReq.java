package com.yulaiz.dong.web.controller.req.ad;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class AdGetByIdReq implements Serializable {

    private static final long serialVersionUID = -3797237723536665442L;

    @ApiModelProperty("广告ID")
    @NotBlank(message = "ID不能为空")
    private String id;
}
