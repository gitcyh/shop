package com.cyh.shop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * wx_address
 * @author 
 */
@Data
public class WXAddressBean implements Serializable {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 用户id
     */
    private String userid;

    /**
     * 地址全称
     */
    private String address;

    /**
     * 家或公司
     */
    private String addressTag;

    /**
     * 授权token
     */
    private String authToken;

    /**
     * 国家码
     */
    private String countryCode;

    /**
     * 国家名称
     */
    private String countryName;

    /**
     * 省份码
     */
    private String provinceCode;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 城市码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 县或区码
     */
    private String districtCode;

    /**
     * 县或区名
     */
    private String districtName;

    /**
     * 详细地址
     */
    private String detailAddress;

    /**
     * 1是默认地址0不是
     */
    private Byte isDefault;

    /**
     * 用户经度
     */
    private BigDecimal longitude;

    /**
     * 用户纬度
     */
    private BigDecimal latitude;

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 手机号码
     */
    private String phoneNumber;

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