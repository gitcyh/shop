package com.cyh.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.UserBean;
import com.cyh.shop.service.UserService;
import com.cyh.shop.util.JWTUtil;
import com.cyh.shop.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/login")
    public Object loin(@RequestBody UserBean userBean){
        UserBean user = userService.selectUserByNamePwd(userBean);
        if(user != null){
            String token = JWTUtil.createToken(user);
            return Result.success().add("token",token)
                    .add("username",user.getUsername())
                    .add("userid",user.getId())
                    .add("pictureId",user.getPictureId());
        }else {
            return Result.fail();
        }
    }

    @PostMapping("/logout")
    public Object logout(@RequestBody UserBean userBean){
        UserBean user = userService.selectUserById(userBean.getId());
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


    @PostMapping("/getUserInfo")
    public Object getUserInfo(@RequestBody JSONObject object){
        String username = object.getString("username");
        UserBean user = userService.selectUserByUserName(username);
        if(user != null){
            return Result.success()
                    .add("userid",user.getId())
                    .add("username",user.getUsername())
                    .add("phone",user.getPhone())
                    .add("email",user.getEmail())
                    .add("pictureId",user.getPictureId());
        }else {
            return Result.fail();
        }
    }

    @PostMapping("/updateUserInfo")
    public Object updateUserInfo(@RequestBody UserBean userBean){
        int result = userService.updateUserInfo(userBean);
        if(result > 0){
            return Result.success();
        }else {
            return Result.fail();
        }
    }


}
