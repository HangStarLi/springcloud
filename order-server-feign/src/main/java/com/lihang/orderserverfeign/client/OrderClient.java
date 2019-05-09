package com.lihang.orderserverfeign.client;

import com.lihang.orderserverfeign.fallback.OrderClientRollback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="product-server",fallback= OrderClientRollback.class)
public interface OrderClient {
    @RequestMapping("list")
    public List findAll();

    @RequestMapping(value = "getById/{productId}" ,method = RequestMethod.POST)
    public String findById(@PathVariable("productId") Integer productId);
}
