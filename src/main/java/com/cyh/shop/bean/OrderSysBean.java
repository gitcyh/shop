package com.cyh.shop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * order_sys
 * @author 
 */
@Data
public class OrderSysBean implements Serializable {
    /**
     * 订单id
     */
    private String id;

    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 下单的用户id
     */
    private String userId;

    /**
     * 店铺id
     */
    private String shopId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 客户id
     */
    private String customerId;

    /**
     * 客户地址
     */
    private String address;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户手机号
     */
    private String customerPhone;

    /**
     * 成交价
     */
    private BigDecimal price;

    /**
     * 成交数量
     */
    private Integer num;

    /**
     * 配送状态0:未配送,1:配送中,2:已配送,3:客户自提,4:其他
     */
    private Byte sendState;

    /**
     * 支付方式0:微信支付,1:支付宝,2:水票,3:月结,4:现金,5:其他
     */
    private Byte payway;

    /**
     * 配送员一般是员工id或客户自提
     */
    private String senderId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 表格行样式
     */
    private String style;

    /**
     * 删除标志1:有效 -1:无效
     */
    private Byte dataFlag;

    /**
     * 订单创建日期可修改
     */
    private Date orderTime;

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