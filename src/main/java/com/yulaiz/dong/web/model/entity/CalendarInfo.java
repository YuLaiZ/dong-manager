package com.yulaiz.dong.web.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarInfo implements Serializable {

    private static final long serialVersionUID = 8694850501884281976L;

    @ApiModelProperty("日历ID")
    private String id;

    @ApiModelProperty("日历标题")
    private String title;

    @ApiModelProperty("日历描述")
    private String description;

    @ApiModelProperty("日历备注")
    private String remark;

}
