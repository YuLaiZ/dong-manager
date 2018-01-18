package com.yulaiz.dong.web.controller.req;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarModifyReq implements Serializable {

    private static final long serialVersionUID = -4410674899432035002L;

    private String id;

    private String title;

    private String description;

    private String remark;
}
