package com.yulaiz.dong.web.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarInfo implements Serializable {

    private static final long serialVersionUID = 8694850501884281976L;

    private String id;

    private String title;

    private String description;

    private String remark;

}
