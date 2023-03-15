package com.cyh.shop.dao;

import com.cyh.shop.bean.GoodsBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsDao {
    int deleteByPrimaryKey(String id);

    int insert(GoodsBean record);

    int insertSelective(GoodsBean record);

    GoodsBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsBean record);

    int updateByPrimaryKey(GoodsBean record);

    List<Map> getGoodsList(String shopId);

    int handleShelfGoods(String id,Integer isSale);

    List<GoodsBean> getWxGoodsList(String shopId);
}