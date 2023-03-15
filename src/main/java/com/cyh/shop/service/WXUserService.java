package com.cyh.shop.service;




import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.cyh.shop.bean.WXUserBean;
import com.cyh.shop.dao.WXUserDao;
import com.cyh.shop.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WXUserService {

    @Autowired
    private WXUserDao wxUserDao;

    @Value("${spring.wx.appSecret}")
    private String secret;

    public WXUserBean loginService(WXUserBean wxUserBean){
        JSONObject jsonObject = jscode2session(wxUserBean);
        WXUserBean user = getUserByopenid(jsonObject,wxUserBean);
        return user;
    }


    public JSONObject jscode2session(WXUserBean wxUserBean){
        String url =  "https://api.weixin.qq.com/sns/jscode2session"
                + "?appid="+ "wx975ff6acd274d5db"
                + "&secret="+secret
                + "&js_code="+wxUserBean.getCode()
                + "&grant_type=authorization_code";
        String result = HttpUtil.createGet(url).execute().charset("utf-8").body();
        JSONObject jsonObject = JSONObject.parseObject(result);
        return jsonObject;
    }

    public WXUserBean getUserByopenid(JSONObject jsonObject, WXUserBean wxUserBean){
        String openid = jsonObject.getString("openid");
        //查询用户是否存在
        WXUserBean userBean = wxUserDao.selectByPrimaryKey(openid);
        if(userBean == null){
            //说明是新用户执行插入操作
            wxUserBean.setId(UUIDUtil.generateId());
            wxUserBean.setSessionKey(jsonObject.getString("session_key"));
            wxUserBean.setOpenid(openid);
            wxUserBean.setUnionid(jsonObject.getString("unionid"));
            wxUserDao.insertSelective(wxUserBean);
            return wxUserBean;
        }
        return userBean;

    }

    public WXUserBean getWXUserByopenid(String openid){
        return wxUserDao.selectByPrimaryKey(openid);
    }

}
