package com.zy.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author by zy.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigureServerConfig {
    public static void main(String argv[]){
        new SpringApplicationBuilder(ConfigureServerConfig.class).web(true).run();
    }
}
