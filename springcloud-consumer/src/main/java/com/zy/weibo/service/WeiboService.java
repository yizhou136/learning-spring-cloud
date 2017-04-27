package com.zy.weibo.service;

import com.google.common.base.Joiner;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author by zy.
 */
@Service
public class WeiboService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(Integer a, Integer b){
        return restTemplate.getForEntity(
                String.format("http://weibo-service/add?a=%d&b=%d", a, b),
                String.class).getBody();
    }

    public String addServiceFallback(Integer a, Integer b){
        return "error a"+a+" b:"+b;
    }
}
