package com.yulaiz.dong.web.controller.req;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarAddReq implements Serializable {

    private static final long serialVersionUID = -5139640489307730235L;

    private String title;

    private String description;

    private String remark;
}
