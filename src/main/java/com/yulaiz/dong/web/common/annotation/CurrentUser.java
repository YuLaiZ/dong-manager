package com.yulaiz.dong.web.common.annotation;

import java.lang.annotation.*;

/**
 * Created by YuLai on 2018/1/25.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
