package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.UserBean;
import com.cyh.shop.service.UserService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/login")
    public Object loin(@RequestBody UserBean userBean){
        UserBean user = userService.selectUserByNamePwd(userBean);
        if(user != null){
            return Result.success();
        }else {
            return Result.fail();
        }
    }


    @PostMapping("/register")
    public Object register(@RequestBody UserBean userBean){
        int code = userService.inserUser(userBean);
        if(code == -1){
            return Result.fail("用户名已存在");
        }else if(code == 0){
            return Result.fail("失败");
        } else {
            return Result.success();
        }
    }


}
