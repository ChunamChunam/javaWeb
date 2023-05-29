package com.example.demo01.day03.mapper;

import com.example.demo01.day03.bean.EmpXml;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapperXml {

    public List<EmpXml> listXml(String name, Short gender, LocalDate begin, LocalDate end);

}
