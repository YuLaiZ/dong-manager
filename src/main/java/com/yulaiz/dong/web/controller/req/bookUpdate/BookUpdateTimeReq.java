package com.yulaiz.dong.web.controller.req.bookUpdate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class BookUpdateTimeReq implements Serializable {

    private static final long serialVersionUID = 599004273580395080L;

    @ApiModelProperty("更新时间，格式：yyyy-MM-dd")
    @NotBlank(message = "更新时间不能为空")
    private String updateTime;
}
