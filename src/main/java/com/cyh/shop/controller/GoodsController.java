package com.cyh.shop.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.GoodsBean;
import com.cyh.shop.service.GoodsService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/addGoods")
    public Object addGoods(@RequestBody GoodsBean goodsBean){
        int result = goodsService.addGoods(goodsBean);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("/getGoodsList")
    public Object getGoodsList(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        List<Map> goodsBeans = goodsService.getGoodsList(shopId);
        return Result.success().add("data",goodsBeans);
    }

    @GetMapping("/getGoods")
    public Object getGoods(HttpServletRequest request){
        String id = request.getParameter("id");
        GoodsBean goodsBean = goodsService.getGoodsById(id);
        if(goodsBean == null){
            return Result.fail();
        }else {
            return Result.success().add("data", goodsBean);
        }
    }

    @PostMapping("/updateGoods")
    public Object updateGoods(@RequestBody GoodsBean goodsBean){
        int result = goodsService.updateGoods(goodsBean);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("/deleteGoods")
    public Object deleteGoods(HttpServletRequest request){
        String id = request.getParameter("id");
        int result = goodsService.deleteGoods(id);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("/searchGoods")
    public Object searchGoods(@RequestBody GoodsBean goodsBean){
        int result = goodsService.updateGoods(goodsBean);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("/handleShelf")
    public Object handleShelf(@RequestBody JSONObject jsonObject){
        String id = jsonObject.getString("id");
        Integer isSale = jsonObject.getInteger("isSale");
        int result = goodsService.handleShelfGoods(id,isSale);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }
}
