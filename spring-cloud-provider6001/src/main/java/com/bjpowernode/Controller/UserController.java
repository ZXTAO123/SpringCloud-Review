package com.bjpowernode.Controller;

import com.bjpowernode.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bjpowernode.pojo.User;

import javax.servlet.http.HttpServlet;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;
    //插入数据
    @GetMapping(value = "insertUser", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String insertUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {

        User user = new User(name, age);
        userService.save(user);
        return "数据插入成功";

    }

    @GetMapping("getUser")
    @ResponseBody
    public User getUser(@RequestParam("id") Integer id) {
        User user = userService.getById(id);
        System.out.println(user);
        System.out.println("提供端："+port);
        return user;
    }
}
