package com.zy.weibo.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by zy.
 */
@FeignClient("weibo-service")
public interface WeiboServiceClient {


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    Integer  add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
