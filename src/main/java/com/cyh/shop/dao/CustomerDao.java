package com.cyh.shop.dao;

import com.cyh.shop.bean.CustomerBean;
import com.cyh.shop.bean.ParameterPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerDao {
    int deleteByPrimaryKey(String id);

    int insert(CustomerBean record);

    int insertForEach(List<Map<String,Object>> list);

    int insertSelective(CustomerBean record);

    CustomerBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerBean record);

    int updateByPrimaryKey(CustomerBean record);

    List<CustomerBean> selectPage(ParameterPage parameterPage);

    int selectCount(String shopId,String value);
}