package com.cyh.shop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * goods
 * @author 
 */
@Data
public class GoodsBean implements Serializable {
    /**
     * 商品id
     */
    private String id;

    /**
     * 商品分类id
     */
    private String categoryId;

    /**
     * 店铺id
     */
    private String shopId;

    /**
     * 商品编号
     */
    private String goodsNum;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 商品规格
     */
    private String specs;

    /**
     * 商品图片id
     */
    private String imgId;

    /**
     * 商品描述
     */
    private String goodsDesc;

    /**
     * 库存余量
     */
    private Integer allowance;

    /**
     * 商品状态-1:违规 0:未审核 1:已审核
     */
    private Byte goodsStatus;

    /**
     * 申请失败原因
     */
    private String applyDesc;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 配送价
     */
    private BigDecimal deliveryPrice;

    /**
     * 自提价
     */
    private BigDecimal selfPrice;

    /**
     * 是否上架0:不上架 1:上架
     */
    private Byte isSale;

    /**
     * 是否精品0:否 1:是
     */
    private Byte isBest;

    /**
     * 是否热销产品0:否 1:是
     */
    private Byte isHot;

    /**
     * 是否新品0:否 1:是
     */
    private Byte isNew;

    /**
     * 是否推荐0:否 1:是
     */
    private Byte isRecom;

    /**
     * 删除标志1:有效 -1:无效
     */
    private Byte dataFlag;

    /**
     * 上架时间
     */
    private Date saleTime;

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