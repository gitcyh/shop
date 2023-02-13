package com.cyh.shop.dao;

import com.cyh.shop.bean.StaffBean;

public interface StaffDao {
    int deleteByPrimaryKey(String id);

    int insert(StaffBean record);

    int insertSelective(StaffBean record);

    StaffBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StaffBean record);

    int updateByPrimaryKey(StaffBean record);
}