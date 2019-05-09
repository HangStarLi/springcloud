package com.lihang.orderserver.service;


/**
 *使用ribbon
 */
public interface ProductOrderService {
    public String saveOrder(Integer productId,Integer userId);

}
