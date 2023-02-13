package com.cyh.shop.controller;

import com.cyh.shop.bean.GoodsSysBean;
import com.cyh.shop.service.GoodsService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/sys/addGoods")
    public Object sys_addGoods(@RequestBody GoodsSysBean goodsSysBean){
        int result = goodsService.addSysGoods(goodsSysBean);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("/sys/getGoodsList")
    public Object sys_getGoodsList(HttpServletRequest request){
        List<Map> goodsSysBeans = goodsService.getSysGoodsList();
        return Result.success().add("data",goodsSysBeans);
    }

    @GetMapping("/sys/getGoods")
    public Object sys_getGoods(HttpServletRequest request){
        String id = request.getParameter("id");
        GoodsSysBean goodsSysBean = goodsService.getSysGoodsById(id);
        if(goodsSysBean == null){
            return Result.fail();
        }else {
            return Result.success().add("data", goodsSysBean);
        }
    }

    @PostMapping("/sys/updateGoods")
    public Object sys_updateGoods(@RequestBody GoodsSysBean goodsSysBean){
        int result = goodsService.updateSysGoods((goodsSysBean));
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("/sys/deleteGoods")
    public Object sys_deleteGoods(HttpServletRequest request){
        String id = request.getParameter("id");
        int result = goodsService.deleteSysGoods(id);
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("/sys/searchGoods")
    public Object sys_searchGoods(@RequestBody GoodsSysBean goodsSysBean){
        int result = goodsService.updateSysGoods((goodsSysBean));
        if(result > 0 ){
            return Result.success();
        }else{
            return Result.fail();
        }
    }
}
