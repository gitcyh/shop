package com.cyh.shop.service;

import com.cyh.shop.bean.OrderSysBean;
import com.cyh.shop.bean.ParameterDate;
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

    public List<Map> getOrders(ParameterDate parameterDate){
        return orderSysDao.getOrders(parameterDate);
    }

    public int updateInfo(String id,String style){
        return orderSysDao.updateInfo(id,style);
    }

    public Map getTotal(ParameterDate parameterDate){
        return orderSysDao.selectTotal(parameterDate);
    }

    public List<Map> getDataYM(ParameterDate parameterDate){
        return orderSysDao.selectDataYM(parameterDate);
    }

    public List<Map> getNumByStaff(ParameterDate parameterDate){
        return orderSysDao.selectNumByStaff(parameterDate);
    }

    public List<Map> getNumByCustomer(ParameterDate parameterDate){
        return orderSysDao.selectNumByCustomer(parameterDate);
    }


}
