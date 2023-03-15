package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.WXAddressBean;
import com.cyh.shop.service.WXAddressService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/wx")
public class WXAddressController {

    @Autowired
    private WXAddressService wxAddressService;

    @PostMapping("/addAddress")
    public Object addAddress(@RequestBody WXAddressBean wxAddressBean){
        int result = wxAddressService.addAddress(wxAddressBean);
        if(result >0){
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/deleteAddress")
    public Object deleteAddress(@PathParam("id") String id){
        int result = wxAddressService.deleteAddress(id);
        if(result >0){
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/updateAddress")
    public Object updateAddress(@RequestBody WXAddressBean wxAddressBean){
        int result = wxAddressService.updateAddress(wxAddressBean);
        if(wxAddressBean.getIsDefault() == 1){
            wxAddressService.updateDefault(wxAddressBean.getId());
        }
        if(result >0){
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("/getAddressList")
    public Object getAddressList(@RequestBody JSONObject jsonObject){
        String userid =jsonObject.getString("userid");
        List<WXAddressBean> list = wxAddressService.getAddressList(userid);
        if(list.size() >0){
            return Result.success().add("data",list);
        }
        return Result.fail();
    }

    @GetMapping("/getAddress")
    public Object getAddress(@PathParam("id") String id){
        WXAddressBean wxAddressBean = wxAddressService.getAddress(id);
        if(wxAddressBean != null){
            return Result.success().add("data",wxAddressBean);
        }
        return Result.fail();
    }



}
