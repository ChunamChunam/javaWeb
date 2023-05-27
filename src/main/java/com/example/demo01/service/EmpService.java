package com.example.demo01.service;

import com.example.demo01.bean.Emp;
import com.example.demo01.dao.EmpDao;

import java.util.List;

public interface EmpService {
    //获取员工列表
    public List<Emp> listEmp();
}
