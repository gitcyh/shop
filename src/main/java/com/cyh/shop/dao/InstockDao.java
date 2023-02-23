package com.cyh.shop.dao;

import com.cyh.shop.bean.GoodsBean;
import com.cyh.shop.bean.InstockBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InstockDao {
    int deleteByPrimaryKey(String id);

    int insert(InstockBean record);

    int insertSelective(InstockBean record);

    InstockBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InstockBean record);

    int updateByPrimaryKey(InstockBean record);

    List<Map> getInstocks(String shopId,String type,String date);

    List<GoodsBean> selectStockAllowance(String shopId);

    List<Map> selectInstockList(String shopId);
}