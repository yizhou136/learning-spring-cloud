package com.zy.apigateway;

import com.zy.apigateway.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


/**
 * @author by zy.
 */
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayConfig {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

    public static void main(String argv[]){
        new SpringApplicationBuilder(ApiGatewayConfig.class).web(true).run();
    }
}
