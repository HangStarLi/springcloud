package com.lihang.orderserverfeign.fallback;

import com.lihang.orderserverfeign.client.OrderClient;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrderClientRollback implements OrderClient {

    @Override
    public List findAll() {
        System.out.println("fallbck调用");
        return null;
    }

    @Override
    public String findById(Integer productId) {
        System.out.println("fallbck调用22222222");
        return null;
    }
}
