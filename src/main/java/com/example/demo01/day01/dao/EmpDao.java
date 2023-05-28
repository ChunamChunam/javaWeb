package com.example.demo01.day01.dao;

import com.example.demo01.day01.bean.Emp;

import java.util.List;

public interface EmpDao {
    //获取员工列表数据
    public List<Emp> listEmp();
}
