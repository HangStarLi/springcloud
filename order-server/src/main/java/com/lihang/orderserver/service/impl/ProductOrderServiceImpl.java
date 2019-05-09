package com.lihang.orderserver.service.impl;

import com.lihang.orderserver.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String saveOrder(Integer productId, Integer userId) {
     //  Object object = restTemplate.getForObject("http://product-server/list", List.class);
        Object object = restTemplate.getForObject("http://product-server/getById/"+productId, Object.class);
        System.out.println(object);
       return object.toString();
    }


}
