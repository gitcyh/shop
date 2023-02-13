package com.cyh.shop.dao;

import com.cyh.shop.bean.CustomerBean;

public interface CustomerDao {
    int deleteByPrimaryKey(String id);

    int insert(CustomerBean record);

    int insertSelective(CustomerBean record);

    CustomerBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerBean record);

    int updateByPrimaryKey(CustomerBean record);
}