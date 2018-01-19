package com.yulaiz.dong.web.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class BookUpdateTimeInfo implements Serializable {

    private static final long serialVersionUID = -5183096545493548761L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("更新时间")
    private Date updateTime;
}
