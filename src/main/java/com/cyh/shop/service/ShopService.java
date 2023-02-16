package com.cyh.shop.service;

import com.cyh.shop.bean.ShopBean;
import com.cyh.shop.dao.ShopDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopDao shopDao;

    public int addShop(ShopBean shopBean){
        shopBean.setId(UUIDUtil.generateId());
        return shopDao.insert(shopBean);
    }

    public int updateShop(ShopBean shopBean){
        return shopDao.updateByPrimaryKey(shopBean);
    }

    public ShopBean getShopById(String id){
        return shopDao.selectByPrimaryKey(id);
    }

    public ShopBean getShopByUserId(String id){
        return shopDao.selectByUserId(id);
    }

    public int deleteShop(String id){
        return shopDao.deleteByPrimaryKey(id);
    }

    public List<ShopBean> getShops(){
        return shopDao.selectAll();
    }

    public int checkShop(String id,int applyStatus,String applyDesc){
        return shopDao.checkShop(id, applyStatus,applyDesc);
    }
}
