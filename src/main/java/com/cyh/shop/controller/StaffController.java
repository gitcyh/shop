package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.StaffBean;
import com.cyh.shop.service.StaffService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;


    @PostMapping("/addStaff")
    public Object addStaff(@RequestBody StaffBean staffBean){
        int result = staffService.addStaff(staffBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/getStaff")
    public Object getStaff(@PathParam("id") String id){
        StaffBean staffBean = staffService.getStaff(id);
        if(staffBean != null){
            return Result.success().add("data",staffBean);
        }
        return Result.fail();
    }

    @PostMapping("/updateStaff")
    public Object updateStaff(@RequestBody StaffBean staffBean){
        int result = staffService.updateStaff(staffBean);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/getStaffs")
    public Object getStaffs(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        List<StaffBean> list = staffService.getStaffs(shopId);
        return Result.success().add("data",list);
    }

    @GetMapping("/deleteStaff")
    public Object deleteStaff(@PathParam("id") String id){
        int result = staffService.deleteStaff(id);
        if(result > 0){
            return Result.success();
        }
        return Result.fail();
    }
}
