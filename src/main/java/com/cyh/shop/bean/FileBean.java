package com.cyh.shop.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * file
 * @author 
 */
@Data
public class FileBean implements Serializable {
    /**
     * 唯一id
     */
    private String id;

    /**
     * 所属店铺id,为空则是系统文件
     */
    private String shopId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    private Date updateTime;

    /**
     * 文件内容
     */
    private byte[] content;

    private static final long serialVersionUID = 1L;
}