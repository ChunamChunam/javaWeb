package com.example.demo01.mapper;

import com.example.demo01.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select(value = "select *from user")
    public List<User> list();
}
