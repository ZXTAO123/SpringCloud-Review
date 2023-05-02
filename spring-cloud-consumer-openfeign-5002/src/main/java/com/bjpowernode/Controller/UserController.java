package com.bjpowernode.Controller;

import ch.qos.logback.core.util.TimeUtil;
import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserController {
    @Resource
    private UserService userService;

    @Value("${server.port}")
    private String port;
    @GetMapping(value = "/Consumer/getUser", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getUserById(@RequestParam("id") Integer id) {
        return this.userService.getUser(id).toString()+",来自："+port;
    }
}
