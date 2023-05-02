package com.bjpowernode;

import com.config.myrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="PROVIDER",configuration = myrule.class)
public class Consumer5001 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer5001.class,args);
    }
}