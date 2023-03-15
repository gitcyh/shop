package com.cyh.shop.dao;

import com.cyh.shop.bean.WXAddressBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WXAddressDao {
    int deleteByPrimaryKey(String id);

    int insert(WXAddressBean record);

    int insertSelective(WXAddressBean record);

    WXAddressBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WXAddressBean record);

    int updateByPrimaryKey(WXAddressBean record);

    List<WXAddressBean> selectAddressList(String userid);

    int updateDefault(String id);
}