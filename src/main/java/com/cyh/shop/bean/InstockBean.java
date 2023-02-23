package com.cyh.shop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * instock
 * @author 
 */
@Data
public class InstockBean implements Serializable {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 店铺id
     */
    private String shopId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 进货凭证id
     */
    private String imgId;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 进货数量
     */
    private Integer num;

    /**
     * 回桶数量
     */
    private Integer bucket;

    /**
     * 进货金额
     */
    private BigDecimal money;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标志1:入库-1退库
     */
    private Byte dataFlag;

    /**
     * 进货日期
     */
    private Date instockTime;

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