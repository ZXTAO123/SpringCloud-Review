package com.bjpowernode.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjpowernode.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public interface UserService extends IService<User> {
    public User getByIdButMistake(Serializable id);
}
