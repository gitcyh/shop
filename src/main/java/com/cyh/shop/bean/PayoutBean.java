package com.cyh.shop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * payout
 * @author 
 */
@Data
public class PayoutBean implements Serializable {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 店铺id
     */
    private String shopId;

    /**
     * 费用类别id
     */
    private String categoryId;

    /**
     * 费用名称
     */
    private String name;

    /**
     * 支出金额
     */
    private BigDecimal amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 费用发生时间
     */
    private Date date;

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