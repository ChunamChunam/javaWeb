package com.example.demo01.day01.mapper;

import com.example.demo01.day01.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select(value = "select *from user")
    public List<User> list();
}
