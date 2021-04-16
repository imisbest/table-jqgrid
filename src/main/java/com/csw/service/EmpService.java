package com.csw.service;

import com.csw.entity.Emp;

import java.util.List;

public interface EmpService {
    void delete(String deptid);

    Integer countPage(Integer pageSize, String deptid);

    List<Emp> queryAllAndByPage(Integer currPage, Integer pageSize, Integer countPage, String deptid);

    void deleteByID(String id);

    Emp queryById(String id);

    void update(Emp emp);

    void add(Emp emp);

    Integer countPage2(Integer rows);

    List<Emp> queryAllAndByPage2(Integer page, Integer rows, Integer countPage);

    Integer count();
}
