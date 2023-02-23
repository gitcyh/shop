package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.PayoutBean;
import com.cyh.shop.service.PayoutService;
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
public class PayoutController {

    @Autowired
    private PayoutService payoutService;

    @PostMapping("/addPayout")
    public Object addPayout(@RequestBody PayoutBean payoutBean){
        int result = payoutService.addPayout(payoutBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }
    @GetMapping("/deletePayout")
    public Object deletePayout(@PathParam("id") String id){
        int result = payoutService.deletePayout(id);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/updatePayout")
    public Object updatePayout(@RequestBody PayoutBean payoutBean){
        int result = payoutService.updatePayout(payoutBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/getPayout")
    public Object getPayout(@PathParam("id") String id){
        PayoutBean payoutBean = payoutService.getPayout(id);
        if(payoutBean != null){
            return Result.success().add("data",payoutBean);
        }
        return Result.fail();
    }

    @PostMapping("/getPayouts")
    public Object getPayouts(){
        List<Map> payoutBeans = payoutService.getPayoutList();
        if(payoutBeans.size() > 0){
            return Result.success().add("data",payoutBeans);
        }
        return Result.fail();
    }
    @PostMapping("/getPayoutChart")
    public Object getPayoutChart(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        List<Map> list = payoutService.getPayoutChart(shopId);
        if(list.size() > 0){
            return Result.success().add("data",list);
        }
        return Result.fail();
    }

}
