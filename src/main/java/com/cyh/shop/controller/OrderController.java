package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.OrderSysBean;
import com.cyh.shop.service.OrderService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/sys/addOrder")
    public Object addOrder(@RequestBody OrderSysBean orderSysBean){
        int result = orderService.addOrder(orderSysBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/sys/deleteOrder")
    public Object deleteOrder(@PathParam("id") String id){
        int result = orderService.deleteOrder(id);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/sys/updateOrder")
    public Object updateOrder(@RequestBody OrderSysBean orderSysBean){
        int result = orderService.updateOrder(orderSysBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/sys/getOrder")
    public Object getOrder(@PathParam("id") String id){
        Map orderSysBean = orderService.getOrder(id);
        if(orderSysBean != null){
            return Result.success().add("data",orderSysBean);
        }
        return Result.fail();
    }

    @PostMapping("/sys/getOrders")
    public Object getOrders(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        List<Map> list = orderService.getOrders(shopId);
        if(list.size() > 0){
            return Result.success().add("data",list);
        }
        return Result.fail();
    }

    @PostMapping("/sys/updateInfo")
    public Object updateInfo(@RequestBody JSONObject jsonObject){
        String bgcolor = jsonObject.getString("bgcolor");
        int result = orderService.updateInfo(bgcolor);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }
}
