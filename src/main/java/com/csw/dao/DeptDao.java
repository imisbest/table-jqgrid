package com.csw.dao;

import com.csw.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HIAPAD on 2019/10/30.
 */
public interface DeptDao {
    List<Dept> queryAll();

    void deleteById(String deptid);

    Dept queryById(String deptid);

    void update(@Param("d") Dept dept);

    void add(@Param("d") Dept dept);
}
