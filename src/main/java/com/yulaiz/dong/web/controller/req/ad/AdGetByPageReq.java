package com.yulaiz.dong.web.controller.req.ad;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class AdGetByPageReq implements Serializable {

    private static final long serialVersionUID = -3031740388569966569L;

    @ApiModelProperty("页数")
    private int page;

    @ApiModelProperty("每页数量")
    private int size;
}
