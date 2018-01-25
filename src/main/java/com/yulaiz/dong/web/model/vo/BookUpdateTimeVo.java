package com.yulaiz.dong.web.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by YuLai on 2018/1/25.
 */
@Data
public class BookUpdateTimeVo implements Serializable {

    private static final long serialVersionUID = -2175370581974074149L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("更新时间")
    private Date updateTime;
}
