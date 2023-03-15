package com.cyh.shop.dao;

import com.cyh.shop.bean.OrderSysBean;
import com.cyh.shop.bean.ParameterDate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderSysDao {
    int deleteByPrimaryKey(String id);

    int insert(OrderSysBean record);

    Map selectByPrimaryKey(String id);

    int updateByPrimaryKey(OrderSysBean record);

    List<Map> getOrders(ParameterDate parameterDate);

    int updateInfo(String id,String style);

    Map selectTotal(ParameterDate parameterDate);

    List<Map> selectDataYM(ParameterDate parameterDate);

    List<Map> selectNumByStaff(ParameterDate parameterDate);

    List<Map> selectNumByCustomer(ParameterDate parameterDate);
}