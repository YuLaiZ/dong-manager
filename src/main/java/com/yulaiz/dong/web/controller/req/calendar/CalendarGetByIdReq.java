package com.yulaiz.dong.web.controller.req.calendar;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarGetByIdReq implements Serializable {

    private static final long serialVersionUID = -9102652134189391153L;

    @ApiModelProperty("日历ID")
    @NotBlank(message = "ID不能为空")
    private String id;
}
