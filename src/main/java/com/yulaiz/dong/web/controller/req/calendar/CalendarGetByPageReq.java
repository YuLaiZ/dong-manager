package com.yulaiz.dong.web.controller.req.calendar;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by YuLai on 2018/2/6.
 */
@Data
public class CalendarGetByPageReq implements Serializable {

    private static final long serialVersionUID = 3233975324290931069L;

    @ApiModelProperty("页数，从1页开始")
    @Min(value = 1, message = "页数必须从1页开始的整数")
    private int page;

    @ApiModelProperty("每页数量")
    @Max(value = 20, message = "每页最大20")
    @Min(value = 1, message = "每页最小1")
    private int size;
}
