package com.cyh.shop.dao;

import com.cyh.shop.bean.OrderSysBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderSysDao {
    int deleteByPrimaryKey(String id);

    int insert(OrderSysBean record);

    int insertSelective(OrderSysBean record);

    Map selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderSysBean record);

    int updateByPrimaryKey(OrderSysBean record);

    List<Map> getOrders(String shopId,String type,String date);

    int updateInfo(String id,String style);
}