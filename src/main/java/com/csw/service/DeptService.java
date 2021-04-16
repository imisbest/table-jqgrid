package com.csw.service;

import com.csw.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> queryAll();

    void delete(String deptid);

    Dept queryById(String deptid);

    void update(Dept dept);

    void add(Dept dept);
}
