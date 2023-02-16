package com.cyh.shop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import lombok.Data;

/**
 * shop
 * @author 
 */
@Data
public class ShopBean implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 店铺所有人id
     */
    private String userId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺地址
     */
    private String shopAddress;

    /**
     * 店铺电话
     */
    private String shopTel;

    /**
     * 店主姓名
     */
    private String shopKeeper;

    /**
     * 店主身份证号码
     */
    private String idCard;

    /**
     * 店主手机号
     */
    private String telephone;

    /**
     * 公司名称
     */
    private String shopCompany;

    /**
     * 店铺图标id
     */
    private String imgId;

    /**
     * 营业执照id
     */
    private String licenseId;

    /**
     * 申请状态-1:申请失败,0:待审核 1:审核通过
     */
    private Integer applyStatus;

    /**
     * 申请失败原因
     */
    private String applyDesc;

    /**
     * 店铺经度
     */
    private BigDecimal longitude;

    /**
     * 店铺纬度
     */
    private BigDecimal latitude;

    /**
     * 开始营业时间
     */
    private Time startTime;

    /**
     * 结束营业时间
     */
    private Time endTime;

    /**
     * 1:营业中 0:休息中
     */
    private Byte shopActive;

    /**
     * 1可用-1删除-2违规
     */
    private Byte dataFlag;

    /**
     * 申请时间
     */
    private Date applyTime;

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