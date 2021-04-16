package com.csw.controller;

import com.csw.entity.Dept;
import com.csw.service.DeptService;
import com.csw.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("d")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private EmpService empService;

    @RequestMapping("showAll")
    @ResponseBody
    public void showAll(HttpServletResponse response) throws IOException {
        List<Dept> depts = deptService.queryAll();
        System.out.println("depts;;"+depts);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder str = new StringBuilder();
        str.append("<select name='did'>");
        for (Dept dept : depts) {
            str.append("<option value='" + dept.getId() + "'>" + dept.getName() + "</option>");
        }
        str.append("</select>");
        out.print(str);
        out.close();
    }

    @RequestMapping("delete")
    public String delete(String deptid) {
        empService.delete(deptid);
        deptService.delete(deptid);
        return "redirect:/d/showAll";
    }

    @RequestMapping("updatefirst")
    public String updatefirst(String deptid, HttpServletRequest request) {
        Dept dept = deptService.queryById(deptid);
        request.setAttribute("dept", dept);
        return "dept/updateDept";
    }

    @RequestMapping("updatelast")
    public String updatelast(Dept dept) {
        System.out.println("dept//：" + dept);
        deptService.update(dept);
        return "redirect:/d/showAll";
    }

    @RequestMapping("add")
    public String add(Dept dept) {
        dept.setId(UUID.randomUUID().toString());
        deptService.add(dept);
        return "redirect:/d/showAll";
    }
}
