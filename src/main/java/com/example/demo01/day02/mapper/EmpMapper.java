package com.example.demo01.day02.mapper;

import com.example.demo01.day02.bean.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete(value = "delete from emp where id=#{id}")//使用#{key}方式获取方法中的参数值
    public void delete(Integer id);

    @Options(keyProperty = "id", useGeneratedKeys = true) // 自动生成的主键值赋给emp对象的id属性
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);


    @Update(value = "UPDATE emp SET username = #{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} WHERE id = #{id}")
    public void update(Emp emp);

//    @Select(value = "SELECT * FROM emp WHERE id = #{id}")
//    public Emp getById(Integer id);

    //  解决方案：
    //1. 起别名
//    @Select(value = "SELECT id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time updateTime FROM emp WHERE id = #{id}")
//    public Emp getById(Integer id);

    //2. 结果映射
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select(value = "SELECT * FROM emp WHERE id = #{id}")
//    public Emp getById(Integer id);

    //3. 开启驼峰命名
//    #开启mybatis的驼峰命名自动影射开关
//mybatis.configuration.map-underscore-to-camel-case=true
    @Select(value = "SELECT * FROM emp WHERE id = #{id}")
    public Emp getById(Integer id);


    // 条件查询员工
//    @Select("select * from emp " +
//            "where name like '%${name}%' " +
//            "and gender = #{gender} " +
//            "and entrydate between #{begin} and #{end} " +
//            "order by update_time desc")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
    // 解决SQL 注入问题
    @Select("select * from emp " +
            "where name like concat('%',#{name},'%')  " +
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

}
