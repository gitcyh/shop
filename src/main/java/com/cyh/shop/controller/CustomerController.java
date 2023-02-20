package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.CustomerBean;
import com.cyh.shop.service.CustomerService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/addCustomer")
    public Object addCustomer(@RequestBody CustomerBean customerBean){
        int result = customerService.addCustomer(customerBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/getCustomer")
    public Object getCustomer(@PathParam("id") String id){
        CustomerBean customerBean = customerService.getCustomer(id);
        if(customerBean != null){
            return Result.success().add("data",customerBean);
        }
        return Result.fail();
    }

    @PostMapping("/updateCustomer")
    public Object updateCustomer(@RequestBody CustomerBean customerBean){
        int result = customerService.updateCustomer(customerBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/getCustomers")
    public Object getCustomers(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        List<CustomerBean> list = customerService.getCustomers(shopId);
        return Result.success().add("data",list);
    }

    @GetMapping("/deleteCustomer")
    public Object deleteCustomer(@PathParam("id") String id){
        int result = customerService.deleteCustomer(id);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }
}
