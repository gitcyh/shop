package com.cyh.shop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * customer
 * @author 
 */
@Data
public class CustomerBean implements Serializable {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 所属店铺id
     */
    private String shopId;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 地址经度
     */
    private BigDecimal longitude;

    /**
     * 地址纬度
     */
    private BigDecimal latitude;

    /**
     * 结算方式0水票1月结2及时支付3其他
     */
    private Byte settlement;

    /**
     * 客户来源0默认人工录入1是微信客户
     */
    private Byte customerForm;


    /**
     * 微信号
     */
    private String wechat;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 1:有效 -1:无效
     */
    private Byte dataFlag;

    /**
     * 备注
     */
    private String remark;

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