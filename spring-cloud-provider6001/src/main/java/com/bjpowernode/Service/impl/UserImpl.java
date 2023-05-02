package com.bjpowernode.Service.impl;

import com.bjpowernode.Service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjpowernode.Mapper.UserMapper;
import org.springframework.stereotype.Service;
import com.bjpowernode.pojo.User;
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
