package com.cyh.shop.dao;

import com.cyh.shop.bean.PayoutBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PayoutDao {
    int deleteByPrimaryKey(String id);

    int insert(PayoutBean record);

    PayoutBean selectByPrimaryKey(String id);

    int updateByPrimaryKey(PayoutBean record);

    List<Map> getPayoutList();

    List<Map> selectPayoutList(String shopId);
}