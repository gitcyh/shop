package com.cyh.shop.util;

import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    public static void main(String[] args) {
        System.out.println(md5("123456cyhZ"));
    }


    /**
     * spring工具类生成md5
     * @param str
     * @return
     */
    public static String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    /**
     * java自带api生成MD5
     * @param str
     * @return
     */
    public static String MD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        }catch (NoSuchAlgorithmException noSuchAlgorithmException){
            return md5(str);
        }
    }

}
