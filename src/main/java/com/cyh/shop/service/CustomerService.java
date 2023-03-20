package com.cyh.shop.service;

import com.cyh.shop.bean.CustomerBean;
import com.cyh.shop.bean.ParameterPage;
import com.cyh.shop.dao.CustomerDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public int addCustomer(CustomerBean customerBean){
        customerBean.setId(UUIDUtil.generateId());
        return customerDao.insert(customerBean);
    }

    public int uploadCustomers(Map<String,Object> data,String shopId){
        List<Map<String,Object>> list = new ArrayList<>();
        for (String key : data.keySet()) {
            Map<String,Object> itemMap = (Map<String, Object>) data.get(key);
            Map<String,Object> map = new HashMap<>();
            for(String k : itemMap.keySet()){
                map.put("shopId",shopId);
                map.put("id", UUIDUtil.generateId());
                map.put("name","系统录入");
                map.put("customerForm",0);
                String value = itemMap.get(k) == null ? "" : itemMap.get(k).toString().trim();
                if(k.trim().equals("客户地址")){
                    map.put("address",value);
                }else if(k.trim().equals("付款方式")){
                    if(value.equals("月结")){
                        map.put("settlement",3);
                    }else if(value.equals("水票")){
                        map.put("settlement",2);
                    }else if(value.equals("网单")){
                        map.put("settlement",7);
                    }else if(value.equals("客户本子")){
                        map.put("settlement",10);
                    }else if(value.contains("对公")){
                        map.put("settlement",8);
                    }else if(value.equals("微信")){
                        map.put("settlement",0);
                    }else if(value.contains("支付宝")){
                        map.put("settlement",1);
                    }else if(value.contains("现金")){
                        map.put("settlement",6);
                    }else{
                        map.put("settlement",0);
                    }
                }else if(k.trim().equals("备注")) {
                    if (value.startsWith("1")) {
                        map.put("phone", value.replaceAll(" ",""));
                    } else {
                        map.put("phone", "");
                    }
                }
            }
            list.add(map);
        }
        return customerDao.insertForEach(list);
    }

    public CustomerBean getCustomer(String id){
        return customerDao.selectByPrimaryKey(id);
    }

    public int updateCustomer(CustomerBean customerBean){
        return customerDao.updateByPrimaryKey(customerBean);
    }

    public List<CustomerBean> getCustomers (ParameterPage parameterPage){
        return customerDao.selectPage(parameterPage);
    }

    public int deleteCustomer(String id){
        return customerDao.deleteByPrimaryKey(id);
    }

    public int getCountCustomers(String shopId,String value){
        return customerDao.selectCount(shopId,value);
    }
}
