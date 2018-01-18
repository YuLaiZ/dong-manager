package com.yulaiz.dong.web.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by YuLai on 2018/1/18.
 */
@Data
public class ExeResult<T> implements Serializable {

    private static final long serialVersionUID = 8811799166093360303L;

    private int code;

    private String result;

    private String message;

    private transient T data;

    public ExeResult(int code, String result, String message, T data) {
        this.code = code;
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public static <T> ExeResult<T> getInstance(int code, String result, String message, T data) {
        return new ExeResult(code, result, message, data);
    }

    public static <T> ExeResult<T> getInstance(String result, String message) {
        return new ExeResult(200, result, message, null);
    }

    public static <T> ExeResult<T> getInstance(T data) {
        return new ExeResult(200, "success", null, data);
    }
}
