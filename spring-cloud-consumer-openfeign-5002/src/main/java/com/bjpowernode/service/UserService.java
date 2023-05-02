package com.bjpowernode.service;

import com.bjpowernode.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Component
@FeignClient(value = "PROVIDER")
public interface UserService {
    @GetMapping("getUser")
    @ResponseBody
    public User getUser(@RequestParam("id") Integer id);
}
