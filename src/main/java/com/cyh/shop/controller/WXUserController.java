package com.cyh.shop.controller;



import com.cyh.shop.bean.WXUserBean;
import com.cyh.shop.service.WXUserService;
import com.cyh.shop.util.Result;
import com.cyh.shop.util.WXJWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WXUserController {

    @Autowired
    private WXUserService wxUserService;

    @PostMapping("/login")
    public Object login(@RequestBody WXUserBean wxuserBean){
        WXUserBean user = wxUserService.loginService(wxuserBean);
        String token = WXJWTUtil.createToken(user);
        return Result.success().add("token",token)
                .add("nickName",user.getNickName())
                .add("avatarUrl",user.getAvatarUrl())
                .add("openid",user.getOpenid());
    }
}
