package com.yulaiz.dong.web.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by YuLai on 2018/1/25.
 */
public class MD5Util {

    private MD5Util() {
        throw new IllegalStateException("Utility class");
    }

    public static String md5(String plainText) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        byte[] strTemp = plainText.getBytes();
        MessageDigest mdTemp = null;
        try {
            mdTemp = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
//            log.error("MD5加密异常,plainText={}", plainText, e);
            throw new RuntimeException("MD5加密异常", e);
        }
        mdTemp.update(strTemp);
        byte[] md = mdTemp.digest();
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.md5("123").toUpperCase());
        //202CB962AC59075B964B07152D234B70
    }
}
