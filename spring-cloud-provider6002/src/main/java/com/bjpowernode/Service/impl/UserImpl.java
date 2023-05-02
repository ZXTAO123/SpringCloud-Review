package com.bjpowernode.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjpowernode.Mapper.UserMapper;
import com.bjpowernode.Service.UserService;
import com.bjpowernode.pojo.User;
import org.springframework.stereotype.Service;
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
