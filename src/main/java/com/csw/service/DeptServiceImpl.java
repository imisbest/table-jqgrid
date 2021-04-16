package com.csw.service;

import com.csw.dao.DeptDao;
import com.csw.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Override
    public void delete(String deptid) {
        deptDao.deleteById(deptid);
    }

    @Override
    public Dept queryById(String deptid) {
        return deptDao.queryById(deptid);
    }

    @Override
    public void update(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public void add(Dept dept) {
        deptDao.add(dept);
    }
}
