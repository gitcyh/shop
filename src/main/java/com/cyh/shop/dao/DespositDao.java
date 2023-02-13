package com.cyh.shop.dao;

import com.cyh.shop.bean.DespositBean;

public interface DespositDao {
    int deleteByPrimaryKey(String id);

    int insert(DespositBean record);

    int insertSelective(DespositBean record);

    DespositBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DespositBean record);

    int updateByPrimaryKey(DespositBean record);
}