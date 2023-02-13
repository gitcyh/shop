package com.cyh.shop.dao;

import com.cyh.shop.bean.GoodsSysBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsSysDao {
    int deleteByPrimaryKey(String id);

    int insert(GoodsSysBean record);

    List<Map> getGoodsList();

    GoodsSysBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsSysBean record);

    int updateByPrimaryKey(GoodsSysBean record);


    List<GoodsSysBean> searchGoods(GoodsSysBean record);
}