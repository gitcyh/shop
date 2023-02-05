package com.cyh.shop.interceptor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cyh.shop.bean.UserBean;
import com.cyh.shop.exception.ServiceException;
import com.cyh.shop.service.UserService;
import com.cyh.shop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JwtInterceptor implements HandlerInterceptor {


    //签名密钥
    private static String signature = "sjdhgkjashdlaksjhyqyewq87wye9qu873264812gashdg12";


    @Autowired
    private UserService userService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //执行认证
        String token = request.getHeader("token");
        if(token == null){
            token = request.getParameter("token");
        }
        if (StrUtil.isBlank(token)){
            noLogin(response);
            throw new ServiceException(401,"无token，请登录");
        }
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            noLogin(response);
            throw new ServiceException(401,"token验证失败");

        }

//        UserBean user = userService.selectUserById(userId);
//        if (user == null) {
//            throw new ServiceException(401,"用户不存在，请重新登录");
//        }

        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(signature)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            noLogin(response);
            throw new ServiceException(401,"非法的token!");
        }
        return true;
    }

    //没登录时返回错误信息
    public void noLogin(HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);// 401
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        res.put("code",HttpServletResponse.SC_UNAUTHORIZED);
        res.put("msg","请登录");
        PrintWriter out = null ;
        try {
            out = response.getWriter();
            out.write(res.toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
