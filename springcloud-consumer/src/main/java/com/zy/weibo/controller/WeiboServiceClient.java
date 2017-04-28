package com.zy.weibo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by zy.
 */
@FeignClient(value = "weibo-service", fallback = WeiboServiceHystrixFallback.class)
public interface WeiboServiceClient {
    public static final Logger logger = LoggerFactory.getLogger(WeiboServiceClient.class);


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod="addFallback")
    Integer  add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);


    default public Integer   addFallback(Integer a, Integer b){
        logger.info("addFallback a:{}, b:{}",a, b);
        return a+b;
    }
}
