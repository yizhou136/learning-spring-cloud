package com.zy.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author by zy.
 */
@SpringBootApplication
@EnableEurekaServer
public class ConfigServer {

    public static void main(String argv[]){
        new SpringApplicationBuilder(ConfigServer.class).web(true).run();
    }
}