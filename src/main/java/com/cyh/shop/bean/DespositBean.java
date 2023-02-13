package com.cyh.shop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * desposit
 * @author 
 */
@Data
public class DespositBean implements Serializable {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 所属客户id,一个客户可能有多张押金单
     */
    private String customerId;

    /**
     * 押金描述
     */
    private String description;

    /**
     * 押金金额
     */
    private BigDecimal money;

    /**
     * 押桶数量
     */
    private Integer num;

    /**
     * 押金文件id
     */
    private String fileId;

    /**
     * 1:有效 -1:无效
     */
    private Byte dataFlag;

    /**
     * 1:已押 -1:未押 0:已退
     */
    private Byte state;

    /**
     * 备注
     */
    private String remark;

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