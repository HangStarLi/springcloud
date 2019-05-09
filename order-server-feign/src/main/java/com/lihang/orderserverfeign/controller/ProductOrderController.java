package com.lihang.orderserverfeign.controller;

import com.lihang.orderserverfeign.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;
    @RequestMapping("order/{productId}")
   /* @HystrixCommand(fallbackMethod = "saveOrderFail")*/
    private Object order(@PathVariable Integer productId){
        System.out.println("lihang");
        Map<String,Object> data = new HashMap<>();
        data.put("code",1);
        productOrderService.saveOrder(productId,2);
       // data.put("msg",productOrderService.saveOrder(productId,2));
        return data;
    }

    /**
     * 使用feign
     */

    /*
    * 熔断
    * */
   public Object saveOrderFail(Integer productId){
       Map<String,Object> map = new HashMap<>();
       map.put("code",-1);
       map.put("msg","ERROR");
       return map;
   }

}
