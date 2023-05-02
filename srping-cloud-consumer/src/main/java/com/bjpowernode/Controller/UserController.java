package com.bjpowernode.Controller;

import com.bjpowernode.pojo.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String port;
    public static final String PROVIDER_URL = "http://PROVIDER";

    @GetMapping(value = "/Consumer/getUser",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String  getUserById(@RequestParam("id") Integer id) {
        ResponseEntity<User> forEntity = restTemplate.getForEntity(PROVIDER_URL +"/getUser?id="+ id, User.class);
        User user = forEntity.getBody();
        System.out.println(user);
        return user.toString()+"，来自："+port;
    }
}
