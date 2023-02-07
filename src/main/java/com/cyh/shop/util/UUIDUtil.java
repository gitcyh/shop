package com.cyh.shop.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.Date;
import java.util.UUID;

public class UUIDUtil {

    /**
     * java工具类生成uuid
     * @return
     */
    public static String generateId(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    /**
     * 随机生成商品编号
     * @return
     */
    public static  String generateGoodsNum(String ...prefix){
        String format = DateUtil.format(new Date(),"yyyyMMddHHmmss");
        String numbers = RandomUtil.randomNumbers(5);
        String num = format+numbers;
        if(prefix.length == 0){
            return num;
        }else{
            return prefix[0]+num;
        }
    }

    public static void main(String[] args) {
        System.out.println( generateGoodsNum());

    }


}
