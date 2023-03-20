package com.cyh.shop.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * wxuser
 * @author 
 */
@Data
public class WXUserBean implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 调用wx.login返回的临时code
     */
    private String code;

    private String cloudId;

    /**
     * 加密的敏感数据
     */
    private String encryptedData;

    /**
     * 微信用户昵称
     */
    private String nickName;

    /**
     * 用户性别0男1女
     */
    private Byte gender;

    /**
     * 语言如zh_CN
     */
    private String language;

    /**
     * 省份
     */
    private String province;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 城市
     */
    private String city;

    /**
     * 国家
     */
    private String country;

    /**
     * 用户头像地址
     */
    private String avatarUrl;

    /**
     * 使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息
     */
    private String signature;

    /**
     * 加密算法的初始向量
     */
    private String iv;

    /**
     * 会话密钥
     */
    private String sessionKey;

    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回
     */
    private String unionid;

    /**
     * 用户唯一标识,非常重要
     */
    private String openid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}