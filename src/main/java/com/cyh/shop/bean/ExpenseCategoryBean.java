package com.cyh.shop.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * expense_category
 * @author 
 */
@Data
public class ExpenseCategoryBean implements Serializable {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

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