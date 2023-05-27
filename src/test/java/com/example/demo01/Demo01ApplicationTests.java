package com.example.demo01;

import com.example.demo01.bean.User;
import com.example.demo01.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //该测试类在运行时，会自动通过引导类加载Spring的环境（IOC容器）。我们要测试那个bean对象，就可以直接通过@Autowired注解直接将其注入进行，然后就可以测试了。
class Demo01ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testList(){
        List<User> userList = userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user.toString());
        });
    }

}
