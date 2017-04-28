package com.zy.weibo.configure.feign;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.Feign;
import feign.Target;
import feign.hystrix.SetterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author by zy.
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public SetterFactory setterFactory(){
        SetterFactory setterFactory = new SetterFactory(){
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                String groupKey = target.name();
                String commandKey = Feign.configKey(target.type(), method);
                return HystrixCommand.Setter
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
                        .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(false)
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE));
            }
        };
        return setterFactory;
    }
}