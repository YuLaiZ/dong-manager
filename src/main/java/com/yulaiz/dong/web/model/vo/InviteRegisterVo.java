package com.yulaiz.dong.web.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/2/2.
 */
@Data
public class InviteRegisterVo implements Serializable {

    private static final long serialVersionUID = -3881523164426794734L;

    private String inviterId;

    private String remark;
}
