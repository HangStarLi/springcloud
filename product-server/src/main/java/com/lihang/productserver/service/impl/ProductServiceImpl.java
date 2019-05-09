package com.lihang.productserver.service.impl;

import com.lihang.productserver.domain.Product;
import com.lihang.productserver.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ProductServiceImpl implements ProductService {
    private static final Map<Integer,Product> map = new HashMap<>();
    static{
        Product product1 = new Product(1,"苹果",2999);
        Product product2 = new Product(2,"华为",3499);
        Product product3 = new Product(3,"三星",1200);
        Product product4 = new Product(4,"小米",1999);
        Product product5 = new Product(5,"诺基亚",500);

        map.put(product1.getId(),product1);
        map.put(product2.getId(),product2);
        map.put(product3.getId(),product3);
        map.put(product4.getId(),product4);
        map.put(product5.getId(),product5);
    }
    @Override
    public List<Product> productList() {
        Collection<Product> collection = map.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product getById(Integer productId) {
        return map.get(productId);
    }
}
