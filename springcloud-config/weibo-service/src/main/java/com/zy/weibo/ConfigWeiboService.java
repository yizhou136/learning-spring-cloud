package com.zy.weibo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author by zy.
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigWeiboService {

    public static void main(String argv[]){
        new SpringApplicationBuilder(ConfigWeiboService.class).web(true).run();
    }
}