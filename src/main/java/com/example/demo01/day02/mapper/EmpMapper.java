package com.example.demo01.day02.mapper;

import com.example.demo01.day02.bean.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete(value = "delete from emp where id=#{id}")//使用#{key}方式获取方法中的参数值
    public void delete(Integer id);

    @Options(keyProperty = "id",useGeneratedKeys = true) // 自动生成的主键值赋给emp对象的id属性
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);
}
