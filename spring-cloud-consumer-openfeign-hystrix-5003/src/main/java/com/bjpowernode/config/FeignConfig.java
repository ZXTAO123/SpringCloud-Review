package com.bjpowernode.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    /**
     * 设置OpenFeign的日志输出
     * @return
     */
    @Bean
    Logger.Level feignLoggingLevel() {
        return Logger.Level.FULL;
    }
}
