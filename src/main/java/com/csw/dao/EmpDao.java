package com.csw.dao;

import com.csw.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HIAPAD on 2019/10/30.
 */
public interface EmpDao {
    void deleteBy(String deptid);

    Integer queryCount(String deptid);

    List<Emp> queryAllAndByPage(@Param("firstIndex") Integer firstIndex,
                                @Param("pageSize") Integer pageSize,
                                @Param("deptid") String deptid);

    void deleteByID(String id);


    Emp queryById(String id);

    void update(@Param("e") Emp emp);

    void add(@Param("e") Emp emp);

    Integer queryCount2();

    List<Emp> queryAllAndByPage2(@Param("firstIndex") Integer firstIndex,@Param("rows") Integer rows);

    Integer count();
}
