package com.cyh.shop.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * staff
 * @author 
 */
@Data
public class StaffBean implements Serializable {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 所属店铺id
     */
    private String shopId;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 年龄
     */
    private Byte age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 入职日期
     */
    private Date entryDate;

    /**
     * 住址
     */
    private String address;

    /**
     * 1:有效 -1:无效
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