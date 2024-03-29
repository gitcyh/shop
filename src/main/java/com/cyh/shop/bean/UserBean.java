package com.cyh.shop.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * UserBean
 * @author英哥
 */
@Data
public class UserBean implements Serializable {
    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱用于找回密码
     */
    private String email;

    /**
     * 头像id
     */
    private String pictureId;

    /**
     * 角色
     */
    private Integer role;

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