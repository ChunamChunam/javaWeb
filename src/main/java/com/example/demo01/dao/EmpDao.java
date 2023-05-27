package com.example.demo01.dao;

import com.example.demo01.bean.Emp;

import java.util.List;

public interface EmpDao {
    //获取员工列表数据
    public List<Emp> listEmp();
}
