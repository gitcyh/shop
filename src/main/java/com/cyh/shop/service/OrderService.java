package com.cyh.shop.service;

import com.cyh.shop.bean.OrderSysBean;
import com.cyh.shop.dao.OrderSysDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderSysDao orderSysDao;

    public int addOrder(OrderSysBean orderSysBean){
        orderSysBean.setId(UUIDUtil.generateId());
        orderSysBean.setOrderNum(UUIDUtil.generateOrderNum());
        return orderSysDao.insert(orderSysBean);
    }

    public int deleteOrder(String id){
        return orderSysDao.deleteByPrimaryKey(id);
    }

    public int updateOrder(OrderSysBean orderBean){
        return orderSysDao.updateByPrimaryKey(orderBean);
    }

    public Map getOrder(String id){
        return orderSysDao.selectByPrimaryKey(id);
    }

    public List<Map> getOrders(String shopId,String type,String date){
        return orderSysDao.getOrders(shopId,type,date);
    }

    public int updateInfo(String id,String style){
        return orderSysDao.updateInfo(id,style);
    }

    public Map getTotal(String shopId,String type,String date){
        return orderSysDao.selectTotal(shopId,type,date);
    }

    public List<Map> getDataYM(String shopId,String type,String date){
        return orderSysDao.selectDataYM(shopId,type,date);
    }

}
