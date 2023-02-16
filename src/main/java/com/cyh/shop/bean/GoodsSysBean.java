package com.cyh.shop.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String categoryId;

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