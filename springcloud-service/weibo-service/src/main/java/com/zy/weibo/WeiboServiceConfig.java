package com.zy.weibo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author by zy.
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class WeiboServiceConfig {

    public static void main(String argv[]){
        new SpringApplicationBuilder(WeiboServiceConfig.class).web(true).run();
    }
}