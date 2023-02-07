package com.cyh.shop.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * goods_sys
 * @author 
 */
@Data
public class GoodsSysBean implements Serializable {
    /**
     * 商品id
     */
    private String id;

    /**
     * 商品分类id
     */
    private String catId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 商品编号
     */
    private String goodsNum;

    /**
     * 商品名称
     */
    private String goodsName;

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
     * 删除标志1:有效 -1:无效
     */
    private Byte dataFlag;

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