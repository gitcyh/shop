package com.cyh.shop.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cyh.shop.bean.UserBean;
import com.cyh.shop.exception.ServiceException;
import com.cyh.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {


    //签名密钥
    private static String signature = "sjdhgkjashdlaksjhyqyewq87wye9qu873264812gashdg12";


    @Autowired
    private UserService userService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //执行认证
        String token = request.getHeader("token");
        if(token == null){
            token = request.getParameter("token");
        }
        System.out.println(token);
        if (StrUtil.isBlank(token)){
            throw new ServiceException(401,"无token，请登录");
        }
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ServiceException(401,"token验证失败");

        }

        UserBean user = userService.selectUserById(userId);
        if (user == null) {
            throw new ServiceException(401,"用户不存在，请重新登录");
        }

        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(signature)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new ServiceException(401,"非法的token!");
        }
        return true;
    }

}
