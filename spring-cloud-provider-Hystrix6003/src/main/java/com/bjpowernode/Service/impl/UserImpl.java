package com.bjpowernode.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjpowernode.Mapper.UserMapper;
import com.bjpowernode.Service.UserService;
import com.bjpowernode.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @HystrixCommand(
            //设置的兜底方案
            fallbackMethod = "MistakeHandler",
            //设置服务降级条件
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "1000")})
    public User getByIdButMistake(Serializable id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return super.getById(id);
    }

    /**
     *      ---以下方法为兜底方案
     * 如果报错fallbackMethod not found，一般情况为兜底方法的传参类型不对，或则方法名对不上
     */
    public User MistakeHandler(@RequestParam("id") Serializable id){
        System.out.println("进入兜底方案");
        return new User(000,"xxx",000);
    }

}
