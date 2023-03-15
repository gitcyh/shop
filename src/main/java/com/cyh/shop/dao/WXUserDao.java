package com.cyh.shop.dao;

import com.cyh.shop.bean.WXUserBean;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface WXUserDao {
    int deleteByPrimaryKey(String id);

    int insert(WXUserBean record);

    int insertSelective(WXUserBean record);

    WXUserBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WXUserBean record);

    int updateByPrimaryKey(WXUserBean record);
}