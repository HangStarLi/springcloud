package com.lihang.orderserverfeign.service.impl;


import com.lihang.orderserverfeign.client.OrderClient;
import com.lihang.orderserverfeign.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private OrderClient orderClient;
    @Override
    public String saveOrder(Integer productId, Integer userId) {
        String product = orderClient.findById(productId);
        return product;
    }

    @Override
    public List findAll() {
        return orderClient.findAll();
    }


}
