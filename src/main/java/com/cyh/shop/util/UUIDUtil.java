package com.cyh.shop.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.Date;
import java.util.UUID;

public class UUIDUtil {

    /**
     * 雪花算法拥有两个变量datacenterId和workerId
     *
     * snowflake通过这两个变量来实现分布式系统下每个服务生成不重复的ID， 但是这两个变量取值必须在 1 - 31之间（包括）
     *
     * 也就是snowflake最多只能支持31*31=961个节点同时使用，且每个节点的datacenterId和workerId不能重复
     * @return
     */
    public static String generateId(){
        //return UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return IdUtil.getSnowflake(1,20).nextId()+"";
    }

    /**
     * 随机生成商品编号
     * @return
     */
    public static String generateGoodsNum(String ...prefix){
        String format = DateUtil.format(new Date(),"yyyyMMddHHmmss");
        String numbers = RandomUtil.randomNumbers(5);
        String num = format+numbers;
        if(prefix.length == 0){
            return num;
        }else{
            return prefix[0]+num;
        }
    }

    /**
     * 雪花算法生成订单编号
     * @return
     */
    public static String generateOrderNum(){
        String format = DateUtil.format(new Date(),"yyyyMMdd");
        return format + IdUtil.getSnowflake(1,20).nextId();
    }


    public static void main(String[] args) {
        System.out.println( generateGoodsNum());
        Long l = IdUtil.createSnowflake(1,31).nextId();
        l.toString();
        System.out.println(l.toString());

    }


}
