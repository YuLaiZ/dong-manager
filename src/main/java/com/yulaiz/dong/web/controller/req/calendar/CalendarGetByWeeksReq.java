package com.yulaiz.dong.web.controller.req.calendar;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarGetByWeeksReq implements Serializable {

    private static final long serialVersionUID = -662772502930701376L;

    @ApiModelProperty("周数，从1周开始")
    @Min(value = 1, message = "周数必须从1周开始的整数")
    private int weeksBegin;

    @ApiModelProperty("几周")
    @Max(value = 20, message = "最大20周")
    @Min(value = 1, message = "最小1周")
    private int weeksSize;
}
