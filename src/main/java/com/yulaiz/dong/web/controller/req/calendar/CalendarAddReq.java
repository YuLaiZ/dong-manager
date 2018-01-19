package com.yulaiz.dong.web.controller.req.calendar;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class CalendarAddReq implements Serializable {

    private static final long serialVersionUID = -5139640489307730235L;

    @ApiModelProperty("日历标题")
    @NotBlank(message = "标题不能为空")
    private String title;

    @ApiModelProperty("日历描述")
    @NotBlank(message = "描述不能为空")
    private String description;

    @ApiModelProperty("日历备注")
    private String remark;
}
