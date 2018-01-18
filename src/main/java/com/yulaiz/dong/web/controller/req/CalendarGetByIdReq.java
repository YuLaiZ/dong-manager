package com.yulaiz.dong.web.controller.req;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarGetByIdReq implements Serializable {

    private static final long serialVersionUID = -9102652134189391153L;

    private String id;
}
