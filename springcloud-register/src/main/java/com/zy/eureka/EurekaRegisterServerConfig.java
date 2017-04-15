package com.zy.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author by zy.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaRegisterServerConfig {

    public static void main(String argv[]){
        new SpringApplicationBuilder(EurekaRegisterServerConfig.class).web(true).run();
    }
}