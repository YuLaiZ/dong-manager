package com.yulaiz.dong.web.common.utils;

import org.springframework.util.StringUtils;

/**
 * Created by YuLai on 2018/1/30.
 */
public class StringUtil extends StringUtils {

    private StringUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String handlerEmptyValue(String str) {
        if (isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static String handlerNullValue(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }
}
