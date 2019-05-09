package com.lihang.productserver.service;

import com.lihang.productserver.domain.Product;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface ProductService {
    public List<Product> productList();
    public Product getById(Integer productId);
}
