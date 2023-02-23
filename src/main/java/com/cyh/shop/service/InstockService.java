package com.cyh.shop.service;

import com.cyh.shop.bean.GoodsBean;
import com.cyh.shop.bean.InstockBean;
import com.cyh.shop.dao.InstockDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InstockService {

    @Autowired
    private InstockDao instockDao;

    public int addInstock(InstockBean instockBean){
        instockBean.setId(UUIDUtil.generateId());
        return instockDao.insert(instockBean);
    }

    public InstockBean getInstock(String id){
        return instockDao.selectByPrimaryKey(id);
    }

    public int updateInstock(InstockBean instockBean){
        return instockDao.updateByPrimaryKey(instockBean);
    }

    public List<Map> getInstocks(String shopId,String type,String date){
        return instockDao.getInstocks(shopId,type,date);
    }

    public int deleteInstock(String id){
        return instockDao.deleteByPrimaryKey(id);
    }

    public List<GoodsBean>  getStockAllowance(String shopId){
        return instockDao.selectStockAllowance(shopId);
    }

    public List<Map> getInstockList(String shopId){
        return instockDao.selectInstockList(shopId);
    }

}
