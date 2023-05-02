package com.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenFienConfig {
    @Bean
    public IRule myRule(){
        return new RoundRobinRule();
    }
}
