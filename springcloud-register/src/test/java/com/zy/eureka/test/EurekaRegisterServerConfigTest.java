package com.zy.eureka.test;

import com.zy.eureka.test.test_import.TestImport;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EurekaServerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

/**
 * @author by zy.
 */
@SpringBootApplication(exclude = {EurekaServerAutoConfiguration.class, EurekaClientAutoConfiguration.class})
//@EnableEurekaServer
@Import(TestImport.class)
public class EurekaRegisterServerConfigTest {

    public static void main(String argv[]){
        new SpringApplicationBuilder(EurekaRegisterServerConfigTest.class).web(true).run();
    }
}