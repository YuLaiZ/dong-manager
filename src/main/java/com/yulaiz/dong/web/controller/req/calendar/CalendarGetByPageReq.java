package com.yulaiz.dong.web.controller.req.calendar;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarGetByPageReq implements Serializable {

    private static final long serialVersionUID = -662772502930701376L;

    @ApiModelProperty("页数")
    private int page;

    @ApiModelProperty("每页数量")
    private int size;
}
