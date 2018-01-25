package com.yulaiz.dong.web.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class CalendarListVo implements Serializable {

    private static final long serialVersionUID = 1157585015251154621L;

    @ApiModelProperty("总数")
    private int total;

    @ApiModelProperty("数据列表")
    private List<CalendarVo> list;
}
