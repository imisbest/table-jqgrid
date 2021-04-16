package com.csw.controller;

import com.csw.entity.Dept;
import com.csw.entity.Emp;
import com.csw.service.DeptService;
import com.csw.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("e")
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    @RequestMapping("qa")
    @ResponseBody
    public Map<String, Object> qa(Integer rows, Integer page) {
        System.out.println("每页的大小rows;;" + rows);
        System.out.println("当前第几页page;;" + page);

        /**
         * 分页回传数据
         */
        Integer countPage = empService.countPage2(rows);
        Integer count=empService.count();
        if (page == -1) {///分页
            page = 0;///分页
        }///分页
        if (page == 0) {///分页
            page = 1;///分页
        }///分页
        if (page == countPage + 1) {///分页
            page = countPage;///分页
        }///分页
        List<Emp> empList = empService.queryAllAndByPage2(page, rows, countPage);
        for (Emp emp2 : empList) {
            System.out.println("queryAllAndByPage2 empList;;" + emp2);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("rows", empList);
        map.put("page", page);
        map.put("total", countPage);
        map.put("records",count );
        /* List<Emp> empList = empService.qa();*/
        return map;
    }

    @RequestMapping("cuid")
    public String cuid(String oper, HttpServletRequest request, HttpServletResponse response, Emp emp) {
        System.out.println("emp;;" + emp);
        System.out.println("oper;;" + oper);
        /**
         *
         */
        if (oper.equals("add")) {
            System.out.println("进入add");
            emp.setId(UUID.randomUUID().toString());
            emp.setDid(emp.getDept().getName());
            empService.add(emp);

        } else if (oper.equals("del")) {
            empService.deleteByID(emp.getId());

        } else if (oper.equals("edit")) {
            emp.setDid(emp.getDept().getName());
            empService.update(emp);
        }
        return null;
    }

    @RequestMapping("queryAndPage")
    public String queryAndPage(HttpServletRequest request, Integer currPage, String deptid) {
        System.out.println("currPage;;" + currPage);
        System.out.println("deptid;;" + deptid);
        HttpSession session = request.getSession();
        System.out.println("deptid//:" + deptid);
        if (deptid != null) {
            session.setAttribute("deptid", deptid);
        }
        if (deptid == null) {
            deptid = (String) session.getAttribute("deptid");
            System.out.println("deptid//:" + deptid);
        }
        /**
         *
         */
        Integer pageSize = 2;
        Integer countPage = empService.countPage(pageSize, deptid);
        request.setAttribute("countPage", countPage);
        if (currPage == -1) {///分页
            currPage = 0;///分页
        }///分页
        if (currPage == 0) {///分页
            currPage = 1;///分页
        }///分页
        if (currPage == countPage + 1) {///分页
            currPage = countPage;///分页
        }///分页
        List<Emp> empList = empService.queryAllAndByPage(currPage, pageSize, countPage, deptid);
        for (Emp emp : empList) {
            System.out.println("empList;;" + emp);
        }
        request.setAttribute("empList", empList);
        request.setAttribute("currPage", currPage);
        return "emp/emplist";
    }

    @RequestMapping("delete")
    public String delete(String id) {
        System.out.println("delete id;;" + id);

        empService.deleteByID(id);
        return "redirect:/e/queryAndPage?currPage=1";
    }

    @RequestMapping("updatefirst")
    public String updatefirst(String id, HttpServletRequest request) {
        System.out.println("updatefirst id;;" + id);
        HttpSession session = request.getSession();
        Emp emp = empService.queryById(id);
        request.setAttribute("emp", emp);
        String deptid = (String) session.getAttribute("deptid");
        Dept dept = deptService.queryById(deptid);
        request.setAttribute("dept", dept);
        List<Dept> depts = deptService.queryAll();
        request.setAttribute("depts", depts);
        return "emp/updateEmp";
    }

    @RequestMapping("update")
    public String update(Emp emp) {
        System.out.println("update emp;;" + emp);
        empService.update(emp);
        return "redirect:/e/queryAndPage?currPage=1";
    }

    @RequestMapping("addfirst")
    public String addfirst(HttpServletRequest request) {
        List<Dept> depts = deptService.queryAll();
        request.setAttribute("depts", depts);
        return "emp/addEmp";
    }

    @RequestMapping("add")
    public String add(Emp emp) {
        System.out.println(" add emp;;" + emp);
        emp.setId(UUID.randomUUID().toString());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");

        System.out.println(" add emp;;" + emp);
        empService.add(emp);
        return "redirect:/e/queryAndPage?currPage=1";
    }
}
