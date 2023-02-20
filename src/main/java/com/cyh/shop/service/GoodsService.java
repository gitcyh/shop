package com.cyh.shop.service;

import com.cyh.shop.bean.GoodsBean;
import com.cyh.shop.dao.GoodsDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public int addGoods(GoodsBean goodsBean){
        goodsBean.setId(UUIDUtil.generateId());
        goodsBean.setGoodsNum(UUIDUtil.generateGoodsNum("WT"));
        return  goodsDao.insert(goodsBean);
    }

    public List<Map> getGoodsList(String shopId){
        return goodsDao.getGoodsList(shopId);
    }

    public GoodsBean getGoodsById(String id){
        return goodsDao.selectByPrimaryKey(id);
    }

    public int updateGoods(GoodsBean goodsBean){
        return  goodsDao.updateByPrimaryKey(goodsBean);
    }

    public int deleteGoods(String id){
        return goodsDao.deleteByPrimaryKey(id);
    }

    public int handleShelfGoods(String id,Integer isSale){
        return  goodsDao.handleShelfGoods(id,isSale);
    }

}
