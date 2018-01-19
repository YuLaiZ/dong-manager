package com.yulaiz.dong.web.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class AdInfo implements Serializable {

    private static final long serialVersionUID = -1852358592083030936L;

    @ApiModelProperty("广告ID")
    private String id;

    @ApiModelProperty("广告标题")
    private String title;

    @ApiModelProperty("广告描述")
    private String description;
}
