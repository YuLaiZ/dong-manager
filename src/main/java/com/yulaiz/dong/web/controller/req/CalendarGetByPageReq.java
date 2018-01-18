package com.yulaiz.dong.web.controller.req;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarGetByPageReq implements Serializable {

    private static final long serialVersionUID = -662772502930701376L;

    private int page;

    private int size;
}
