package com.cyh.shop.util;

import java.util.UUID;

public class UUIDUtil {

    /**
     * java工具类生成uuid
     * @return
     */
    public static String generateId(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }


}
