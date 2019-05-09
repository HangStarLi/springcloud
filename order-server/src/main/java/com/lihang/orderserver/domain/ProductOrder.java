package com.lihang.orderserver.domain;

import java.io.Serializable;
import java.util.Date;

public class ProductOrder implements Serializable {
    private Integer productId;
    private Integer userId;
    private Date createTime;
    private String productName;

    public Integer getOrderId() {
        return productId;
    }

    public void setOrderId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
