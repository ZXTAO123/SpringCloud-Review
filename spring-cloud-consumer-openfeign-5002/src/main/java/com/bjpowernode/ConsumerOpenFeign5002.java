package com.bjpowernode;

import com.bjpowernode.config.FeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RibbonClient(name="PROVIDER",configuration = FeignConfig.class)
public class ConsumerOpenFeign5002 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeign5002.class,args);
    }
}