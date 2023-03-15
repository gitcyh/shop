package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.OrderSysBean;
import com.cyh.shop.bean.ParameterDate;
import com.cyh.shop.service.OrderService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pc")
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
    public Object getOrders(@RequestBody ParameterDate parameterDate){
        List<Map> list = orderService.getOrders(parameterDate);
        if(list.size() > 0){
            return Result.success().add("data",list);
        }
        return Result.fail();
    }

    @PostMapping("/sys/updateInfo")
    public Object updateInfo(@RequestBody JSONObject jsonObject){
        String style = jsonObject.getString("style");
        String id = jsonObject.getString("id");
        int result = orderService.updateInfo(id,style);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    /**
     * 统计销售额和数量
     * @param jsonObject
     * @return
     */
    @PostMapping("/sys/getTotal")
    public Object getTotal(@RequestBody ParameterDate parameterDate){
        Map map = orderService.getTotal(parameterDate);
        if(map != null){
            return Result.success().add("data",map);
        }
        return Result.fail();
    }

    /**
     * 统计每天或每月的销售额
     * @param jsonObject
     * @return
     */
    @PostMapping("/sys/getDataYM")
    public Object getDataYM(@RequestBody ParameterDate parameterDate){
        List<Map> map = orderService.getDataYM(parameterDate);
        return Result.success().add("data",map);
    }

    /**
     * 统计员工送货排名
     * @param parameterDate
     * @return
     */
    @PostMapping("/sys/getNumByStaff")
    public Object getNumByStaff(@RequestBody ParameterDate parameterDate){
        List<Map> map = orderService.getNumByStaff(parameterDate);
        return Result.success().add("data",map);
    }

    /**
     * 查询客户消费数量
     * @param parameterDate
     * @return
     */
    @PostMapping("/sys/getNumByCustomer")
    public Object getNumByCustomer(@RequestBody ParameterDate parameterDate){
        List<Map> map = orderService.getNumByCustomer(parameterDate);
        return Result.success().add("data",map);
    }


}
