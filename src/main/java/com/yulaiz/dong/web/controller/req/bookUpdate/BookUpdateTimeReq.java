package com.yulaiz.dong.web.controller.req.bookUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by YuLai on 2018/1/19.
 */
@Data
public class BookUpdateTimeReq implements Serializable {

    private static final long serialVersionUID = 599004273580395080L;

    @ApiModelProperty("更新时间，格式：yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
