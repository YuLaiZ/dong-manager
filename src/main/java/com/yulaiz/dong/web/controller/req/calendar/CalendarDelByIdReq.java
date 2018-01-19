package com.yulaiz.dong.web.controller.req.calendar;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarDelByIdReq implements Serializable {

    private static final long serialVersionUID = 4173303385196886858L;

    @ApiModelProperty("日历ID")
    private String id;
}
