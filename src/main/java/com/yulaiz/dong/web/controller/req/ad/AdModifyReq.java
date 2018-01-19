package com.yulaiz.dong.web.controller.req.ad;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class AdModifyReq implements Serializable {

    private static final long serialVersionUID = 2060169232776165529L;

    @ApiModelProperty("广告ID")
    @NotBlank(message = "ID不能为空")
    private String id;

    @ApiModelProperty("广告标题")
    @NotBlank(message = "标题不能为空")
    private String title;

    @ApiModelProperty("广告描述")
    @NotBlank(message = "描述不能为空")
    private String description;

}
