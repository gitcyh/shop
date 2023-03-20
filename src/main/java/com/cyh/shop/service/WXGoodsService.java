package com.cyh.shop.service;


import com.cyh.shop.bean.GoodsBean;
import com.cyh.shop.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WXGoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public List<GoodsBean> getWxGoodsList(String shopId){
        return goodsDao.getWxGoodsList(shopId);
    }

    public List<GoodsBean> getIndexGoods(){
        return goodsDao.selectIndexGoods();
    }



}
