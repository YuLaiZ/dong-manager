package com.yulaiz.dong.web.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/25.
 */
@Data
public class CalendarVo implements Serializable {

    private static final long serialVersionUID = 2482366645663729033L;

    @ApiModelProperty("日历ID")
    private String id;

    @ApiModelProperty("日历标题")
    private String title;

    @ApiModelProperty("日历描述")
    private String description;

    @ApiModelProperty("日历备注")
    private String remark;

}