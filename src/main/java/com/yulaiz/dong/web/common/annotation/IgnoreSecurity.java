package com.yulaiz.dong.web.common.annotation;

import java.lang.annotation.*;

/**
 * 标识是否忽略登录检查
 * Created by YuLai on 2018/1/19.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSecurity {
}
