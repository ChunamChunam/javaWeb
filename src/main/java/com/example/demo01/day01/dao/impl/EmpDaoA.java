package com.example.demo01.day01.dao.impl;

import com.example.demo01.day01.bean.Emp;
import com.example.demo01.day01.dao.EmpDao;
import com.example.demo01.day01.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        //1. 加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
