package com.bjpowernode.Controller;

import com.bjpowernode.Service.UserService;
import com.bjpowernode.pojo.User;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Value(value = "${server.port}")
    private String port;

    //插入数据
    @GetMapping(value = "insertUser",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String insertUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        User user = new User(name, age);
        userService.save(user);
        return "数据插入成功";
        
    }

    @GetMapping("getUser")
    @ResponseBody
    public User getUser(@RequestParam("id") Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        User user = userService.getById(id);
        System.out.println(user);
        System.out.println("提供端："+port);
        return user;

    }
}
