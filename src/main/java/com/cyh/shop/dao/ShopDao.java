package com.cyh.shop.dao;

import com.cyh.shop.bean.ShopBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopDao {
    int deleteByPrimaryKey(String id);

    int insert(ShopBean record);

    int insertSelective(ShopBean record);

    ShopBean selectByPrimaryKey(String id);

    ShopBean selectByUserId(String userId);

    int updateByPrimaryKeySelective(ShopBean record);

    int updateByPrimaryKey(ShopBean record);

    List<ShopBean> selectAll();

    int checkShop(String id,int applyStatus,String applyDesc);
}