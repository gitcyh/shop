package com.cyh.shop.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * brand_sys
 * @author 
 */
@Data
public class BrandSysBean implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 品牌名称
     */
    private String brand;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    private Date updateTime;

    /**
     * 删除标志1:有效 -1:无效
     */
    private Integer dataFlag;

    private static final long serialVersionUID = 1L;
}