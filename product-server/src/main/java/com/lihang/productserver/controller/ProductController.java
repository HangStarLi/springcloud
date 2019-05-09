package com.lihang.productserver.controller;

import com.lihang.productserver.domain.Product;
import com.lihang.productserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
     @Value("${server.port}")
     private String port;

     @RequestMapping("list")
    public List list(){
        List list = productService.productList();
        list.add(new Product(7,port,00000));
        return list;
    }

    @RequestMapping("getById/{productId}")
    public Product getById(@PathVariable Integer productId){
         return productService.getById(productId);
    }

}
