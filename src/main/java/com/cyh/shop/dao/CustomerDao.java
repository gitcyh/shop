package com.cyh.shop.dao;

import com.cyh.shop.bean.CustomerBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerDao {
    int deleteByPrimaryKey(String id);

    int insert(CustomerBean record);

    int insertSelective(CustomerBean record);

    CustomerBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerBean record);

    int updateByPrimaryKey(CustomerBean record);

    List<CustomerBean> selectAll();
}