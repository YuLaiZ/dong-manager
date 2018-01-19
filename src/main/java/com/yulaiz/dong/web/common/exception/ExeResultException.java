package com.yulaiz.dong.web.common.exception;

/**
 * Created by YuLai on 2018/1/19.
 */
public class ExeResultException extends RuntimeException {

    private static final long serialVersionUID = 4352870237083896207L;

    public ExeResultException() {
    }

    public ExeResultException(String message) {
        super(message);
    }

    public ExeResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExeResultException(Throwable cause) {
        super(cause);
    }
}
