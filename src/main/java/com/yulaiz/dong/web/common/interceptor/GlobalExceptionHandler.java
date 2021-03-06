package com.yulaiz.dong.web.common.interceptor;

import com.yulaiz.dong.web.common.exception.ExeResultException;
import com.yulaiz.dong.web.common.response.ExeResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by YuLai on 2018/1/19.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ExeResultException.class)
    @ResponseBody
    public ExeResult handleExeResultException(ExeResultException e) {
        return ExeResult.getInstance("false", e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ExeResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> errorList = e.getBindingResult().getFieldErrors();
        StringBuffer sb = new StringBuffer();
        for (FieldError fieldError : errorList) {
            sb.append(fieldError.getDefaultMessage());
            sb.append(", ");
        }
        return ExeResult.getInstance("false", sb.substring(0, sb.length() - 2));
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ExeResult handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error(e.getMessage());
        return ExeResult.getInstance("false", "操作数据库失败");
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ExeResult handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage());
        if (e.getMessage().indexOf("java.util.Date") != -1) {
            return ExeResult.getInstance("false", "日期格式有误");
        }
        return ExeResult.getInstance("false", "操作失败");
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExeResult handleException(Exception e) {
        log.error(e.getMessage());
        return ExeResult.getInstance("false", "操作失败");
    }

}
