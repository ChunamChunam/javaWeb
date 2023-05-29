package com.example.demo01;

import com.example.demo01.day01.bean.User;
import com.example.demo01.day01.mapper.UserMapper;
import com.example.demo01.day02.bean.Emp;
import com.example.demo01.day02.mapper.EmpMapper;
import com.example.demo01.day03.bean.EmpXml;
import com.example.demo01.day03.mapper.EmpMapperXml;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest //该测试类在运行时，会自动通过引导类加载Spring的环境（IOC容器）。我们要测试那个bean对象，就可以直接通过@Autowired注解直接将其注入进行，然后就可以测试了。
class Demo01ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpMapperXml empMapperXml;
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
    @Test
    public void testUpdate(){
        //要修改的员工信息
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("songdaxia");
        emp.setPassword(null);
        emp.setName("老宋");
        emp.setImage("2.jpg");
        emp.setGender((short)1);
        emp.setJob((short)2);
        emp.setEntrydate(LocalDate.of(2012,1,1));
        emp.setCreateTime(null);
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(2);
        //调用方法，修改员工数据
        empMapper.update(emp);
    }


    @Test
    public void getById(){
        Emp emp = empMapper.getById(18);
        System.out.println(emp);
    }
    @Test
    public void testList2(){
        List<Emp> empList = empMapper.list("张", (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        System.out.println(empList);
    }
    @Test
    public void testMybatisXml(){
        List<EmpXml> empList = empMapperXml.listXml("张", (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        System.out.println(empList);
    }
    // 动态SQL
    @Test
    public void testMybatisSQL(){
//        List<EmpXml> empList = empMapperXml.listXml("张", null,null,null);
        List<EmpXml> empList = empMapperXml.listXml(null, null,null,null);
        System.out.println(empList);
    }
    @Test
    public void testMybatisUpdateSQL(){
        //要修改的员工信息
        EmpXml empXml = new EmpXml();
        empXml.setId(18);
        empXml.setUsername("songdaxiaUpdate");
        empXml.setName("老宋更新");
        empXml.setGender((short)2);
        empXml.setUpdateTime(LocalDateTime.now());
        //调用方法，修改员工数据
        empMapperXml.updateSQL(empXml);
    }
    // 批量删除员工数据
    @Test
    public void testDeleteByIds(){
        List<Integer> ids = Arrays.asList(18,20);
        empMapperXml.deleteEmpById(ids);
    }
}
