package com.yulaiz.dong.web.common.utils;

import java.util.UUID;

/**
 * Created by YuLai on 2018/1/19.
 */
public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(4);
    }

    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}