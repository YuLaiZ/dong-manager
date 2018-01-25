package com.yulaiz.dong.web.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class AdServiceListVo implements Serializable {

    private static final long serialVersionUID = 5186782076487073780L;

    @ApiModelProperty("总数")
    private int total;

    @ApiModelProperty("数据列表")
    private List<AdVo> list;
}
