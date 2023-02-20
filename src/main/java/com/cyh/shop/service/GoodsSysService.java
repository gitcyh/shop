package com.cyh.shop.service;

import com.cyh.shop.bean.GoodsSysBean;
import com.cyh.shop.dao.GoodsSysDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsSysService {

    @Autowired
    private GoodsSysDao goodsSysDao;

    public int addSysGoods(GoodsSysBean goodsSysBean){
        goodsSysBean.setId(UUIDUtil.generateId());
        goodsSysBean.setGoodsNum(UUIDUtil.generateGoodsNum("WT"));
        return  goodsSysDao.insert(goodsSysBean);
    }

    public List<Map> getSysGoodsList(){
        return goodsSysDao.getGoodsList();
    }

    public GoodsSysBean getSysGoodsById(String id){
        return goodsSysDao.selectByPrimaryKey(id);
    }

    public int updateSysGoods(GoodsSysBean goodsSysBean){
        return  goodsSysDao.updateByPrimaryKey(goodsSysBean);
    }

    public int deleteSysGoods(String id){
        return goodsSysDao.deleteByPrimaryKey(id);
    }

}
