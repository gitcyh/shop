package com.cyh.shop.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cyh.shop.bean.UserBean;
import com.cyh.shop.bean.WXUserBean;
import com.cyh.shop.service.UserService;
import com.cyh.shop.service.WXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class WXJWTUtil {

    //签名密钥
    private static String signature = "sjdhgkjashdlaksjhyqyewq87wye9qu873264812gashdg12";

    @Autowired
    private static WXUserService wxUserService;


    /**
     * 生成token
     * @return
     */
    public static String createToken(WXUserBean wxUserBean){
        return JWT.create().withAudience(wxUserBean.getOpenid()) // 将 openid 作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(),24*30)) //24 *30小时后token过期
                .sign(Algorithm.HMAC256(signature));
    }

    /**
     * 解出token里的信息
     * @param token
     * @return
     */
    public String decode(String token,String key) {
        //创建解码对象 利用JWT签名完成解码的创建
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(signature)).build();
        //包含了JWT解码信息
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        //利用键，得到存放在邮箱负载payload中的数据
        return decodedJWT.getClaim(key).asString();
    }

    /**
     * 根据tokrn获取当前用户信息
     * @return
     */
    public static WXUserBean getWXUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (StrUtil.isNotBlank(token)) {
                String openid = JWT.decode(token).getAudience().get(0);
                return wxUserService.getWXUserByopenid(openid);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}

