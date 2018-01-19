package com.yulaiz.dong.web.controller.req.bookUpdate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class BookUpdateTimeReq implements Serializable {

    private static final long serialVersionUID = 599004273580395080L;

    @ApiModelProperty("更新时间")
    private String updateTime;
}
