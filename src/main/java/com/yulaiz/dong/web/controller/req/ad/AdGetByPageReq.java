package com.yulaiz.dong.web.controller.req.ad;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class AdGetByPageReq implements Serializable {

    private static final long serialVersionUID = -3031740388569966569L;

    @ApiModelProperty("页数，从1页开始")
    @Min(value = 1, message = "页数必须从1页开始的整数")
    private int page;

    @ApiModelProperty("每页数量")
    @Max(value = 20, message = "每页最大20")
    @Min(value = 1, message = "每页最小1")
    private int size;
}
