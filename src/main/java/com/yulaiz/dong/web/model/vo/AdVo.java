package com.yulaiz.dong.web.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/25.
 */
@Data
public class AdVo implements Serializable {

    private static final long serialVersionUID = -5985240741609528259L;

    @ApiModelProperty("广告ID")
    private String id;

    @ApiModelProperty("广告标题")
    private String title;

    @ApiModelProperty("广告描述")
    private String description;
}
