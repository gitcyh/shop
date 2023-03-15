package com.cyh.shop.bean;

import java.io.Serializable;

public class ParameterPage implements Serializable {

    /**
     * 店铺id
     */
    private String shopId;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示数据量
     */
    private Integer pageSize;


    /**
     * 查询值可为空
     */
    private String value;


    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
