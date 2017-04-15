package com.zy.weibo.controller;

import com.zy.weibo.service.WeiboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author by zy.
 */
@RefreshScope
@RestController
public class ConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private WeiboServiceClient weiboServiceClient;

    @Autowired
    private WeiboService weiboService;

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Integer a, Integer b){
        logger.info("add a:{}, b:{}  the env from str:{}",
                a, b, from);
        return weiboService.addService(a, b);
    }

    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public Integer add2(Integer a, Integer b){
        logger.info("add2 by feign the env from str:{}",
                from);
        return weiboServiceClient.add(a, b);
    }
}
