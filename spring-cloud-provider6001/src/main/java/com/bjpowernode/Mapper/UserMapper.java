package com.bjpowernode.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.bjpowernode.pojo.User;
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
