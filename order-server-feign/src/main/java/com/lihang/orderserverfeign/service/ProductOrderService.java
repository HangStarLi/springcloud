package com.lihang.orderserverfeign.service;


import java.util.List;

/**
 *使用ribbon
 */
public interface ProductOrderService {
    public String saveOrder(Integer productId, Integer userId);
    public List findAll();
}
