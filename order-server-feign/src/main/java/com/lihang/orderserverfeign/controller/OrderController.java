package com.lihang.orderserverfeign.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.lihang.orderserverfeign.client.OrderClient;
import com.lihang.orderserverfeign.service.ProductOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
public class OrderController {
    @Autowired
    private ProductOrderService service;
    /*报警机制*/
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("listall")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "listFailBack")
    public String getAll(){
        System.out.println("lihang");
        return service.findAll().toString();
    }

    @RequestMapping("get/{productId}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "getFailBack")
    public String getById(@PathVariable("productId") Integer productId){
        return service.saveOrder(productId,2);
    }

    private String  listFailBack(){
       String saveOrderKey = "order-server";
       String sendValue = (String) redisTemplate.opsForValue().get(saveOrderKey);
        new Thread(()->{
             if (StringUtils.isBlank(sendValue)){
                 System.out.println("订单服务发生重大异常，请及时处理");
                 redisTemplate.opsForValue().set(saveOrderKey, "save-order-fail", 20, TimeUnit.SECONDS);
             }else{
                 System.out.println("短信已发送，20s内不重复发送");
             }
        }).start();

        return "list您的包裹飞走了";
    }

    private String getFailBack(Integer productId){
        return "get包裹飞走了";
    }
}
