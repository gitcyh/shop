package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.DespositBean;
import com.cyh.shop.service.DespositService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class DespositController {

    @Autowired
    private DespositService despositService;

    @PostMapping("/addDesposit")
    public Object addDesposit(@RequestBody DespositBean despositBean){
        int result = despositService.addDesposit(despositBean);
        if(result > 0){
            return Result.success();
        }
        return  Result.fail();
    }

    @GetMapping("/deleteDesposit")
    public Object deleteDesposit(@PathParam("id") String id){
        int result = despositService.deleteDesposit(id);
        if(result > 0){
            return Result.success();
        }
        return  Result.fail();
    }

    @PostMapping("/updateDesposit")
    public Object updateDesposit(@RequestBody DespositBean despositBean){
        int result = despositService.updateDesposit(despositBean);
        if(result > 0){
            return Result.success();
        }
        return  Result.fail();
    }

    @GetMapping("/getDesposit")
    public Object getDesposit(@PathParam("id") String id){
        DespositBean despositBean = despositService.getDesposit(id);
        if(despositBean != null){
            return Result.success().add("data",despositBean);
        }
        return  Result.fail();
    }

    @PostMapping("/getDesposits")
    public Object getDesposits(@RequestBody JSONObject jsonObject){
        String customerId = jsonObject.getString("customerId");
        List<DespositBean> list = despositService.getDesposits(customerId);
        return Result.success().add("data",list);
    }
}
