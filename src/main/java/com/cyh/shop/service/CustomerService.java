package com.cyh.shop.service;

import com.cyh.shop.bean.CustomerBean;
import com.cyh.shop.dao.CustomerDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;



    public int addCustomer(CustomerBean customerBean){
        customerBean.setShopId(UUIDUtil.generateId());
        customerBean.setId(UUIDUtil.generateId());
        return customerDao.insert(customerBean);
    }

    public CustomerBean getCustomer(String id){
        return customerDao.selectByPrimaryKey(id);
    }

    public int updateCustomer(CustomerBean customerBean){
        return customerDao.updateByPrimaryKey(customerBean);
    }

    public List<CustomerBean> getCustomers (){
        return customerDao.selectAll();
    }

    public int deleteCustomer(String id){
        return customerDao.deleteByPrimaryKey(id);
    }
}
