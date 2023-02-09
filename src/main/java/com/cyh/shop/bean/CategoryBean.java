package com.cyh.shop.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * category
 * @author 
 */
@Data
public class CategoryBean implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 二级标题
     */
    private String subTitle;

    /**
     * 分类等级,如一级分类二级分类默认一级分类
     */
    private Byte level;

    /**
     * 删除标志1:有效 -1:删除
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