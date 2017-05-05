package com.zy.weibo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by zy.
 */
@FeignClient(value = "weibo-service", fallback = WeiboServiceHystrixFallback.class)
public interface WeiboServiceClient {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @HystrixCommand(commandProperties =
            {@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY,value = "SEMAPHORE"),
             @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value = "500")})
    Integer  add(@RequestParam("a")Integer a, @RequestParam("b") Integer b);
}