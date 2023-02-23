package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.GoodsBean;
import com.cyh.shop.bean.InstockBean;
import com.cyh.shop.service.InstockService;
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
public class InstockController {

    @Autowired
    private InstockService instockService;


    @PostMapping("/addInstock")
    public Object addInstock(@RequestBody InstockBean instockBean){
        int result = instockService.addInstock(instockBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/getInstock")
    public Object getInstock(@PathParam("id") String id){
        InstockBean instockBean = instockService.getInstock(id);
        if(instockBean != null){
            return Result.success().add("data",instockBean);
        }
        return Result.fail();
    }

    @PostMapping("/updateInstock")
    public Object updateInstock(@RequestBody InstockBean instockBean){
        int result = instockService.updateInstock(instockBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/getInstocks")
    public Object getInstocks(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        String type = jsonObject.getString("type");
        String date = jsonObject.getString("date");
        List<Map> list = instockService.getInstocks(shopId,type,date);
        if(list.size() != 0){
            return Result.success().add("data",list);
        }
        return Result.fail();
    }

    @GetMapping("/deleteInstock")
    public Object deleteInstock(@PathParam("id") String id){
        int result = instockService.deleteInstock(id);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/getStockQuantity")
    public Object getStockQuantity(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        List<GoodsBean> list = instockService.getStockAllowance(shopId);
        return Result.success().add("data",list);
    }

    @PostMapping("/getInstockList")
    public  Object getInstockList(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        List<Map> list = instockService.getInstockList(shopId);
        return Result.success().add("data",list);
    }
}
