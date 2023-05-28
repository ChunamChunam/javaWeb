package com.example.demo01;

import com.example.demo01.day01.bean.User;
import com.example.demo01.day01.mapper.UserMapper;
import com.example.demo01.day02.bean.Emp;
import com.example.demo01.day02.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest //该测试类在运行时，会自动通过引导类加载Spring的环境（IOC容器）。我们要测试那个bean对象，就可以直接通过@Autowired注解直接将其注入进行，然后就可以测试了。
class Demo01ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;
    @Test
    public void testList(){
        List<User> userList = userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user.toString());
        });
    }

    @Test
    public void testDel(){
//        int delete = empMapper.delete(17); // 返回值为删除的条数
    empMapper.delete(16);
    }
    @Test
    public void testInsert(){
//        int delete = empMapper.delete(17); // 返回值为删除的条数
        //创建员工对象
        Emp emp = new Emp();
        emp.setUsername("xuanshao");
        emp.setName("轩少");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        //调用添加方法
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

}
