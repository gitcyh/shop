package com.cyh.shop.bean;

import java.io.Serializable;

public class ParameterDate implements Serializable {

    /**
     * 店铺id
     */
    private String shopId;

    /**
     * 参数类别年月日
     */
    private String type;

    /**
     * 参数具体值
     */
    private String date;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
