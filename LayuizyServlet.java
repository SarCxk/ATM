package com.hp.controller;

import com.alibaba.fastjson.JSON;
import com.hp.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LayuizyServlet",urlPatterns = "/LayuizyServlet")
public class LayuizyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        //自己创建一个layui后台的json格式
        List<Student> students = new ArrayList<>();
        Student s1 = new Student();
        s1.setName("一一");
        s1.setAge(15);
        s1.setId(1);
        students.add(s1);

        Student s2 = new Student();
        s2.setName("尔尔");
        s2.setAge(16);
        s2.setId(2);
        students.add(s2);

        Student s3 = new Student();
        s3.setName("三三");
        s3.setAge(17);
        s3.setId(3);
        students.add(s3);

        Student s4 = new Student();
        s4.setName("思思");
        s4.setAge(16);
        s4.setId(4);
        students.add(s4);

        Student s5 = new Student();
        s5.setName("呜呜");
        s5.setAge(17);
        s5.setId(5);

        students.add(s5);

        Student s6 = new Student();
        s6.setName("六六");
        s6.setAge(16);
        s6.setId(6);

        students.add(s6);

        Student s7 = new Student();
        s7.setName("七七");
        s7.setAge(17);
        s7.setId(7);

        students.add(s7);

        Student s8 = new Student();
        s8.setName("爸爸");
        s8.setAge(21);
        s8.setId(8);

        students.add(s8);

        Student s9 = new Student();
        s9.setName("久久");
        s9.setAge(23);
        s9.setId(9);

        students.add(s9);

        Student s10 = new Student();
        s10.setName("试试");
        s10.setAge(23);
        s10.setId(10);

        students.add(s10);

        Student s11 = new Student();
        s11.setName("十一");
        s11.setAge(23);
        s11.setId(11);

        students.add(s11);

        Student s12 = new Student();
        s12.setName("12");
        s12.setAge(23);
        s12.setId(12);
        students.add(s12);

        Student s13 = new Student();
        s13.setName("十三");
        s13.setAge(21);
        s13.setId(13);

        students.add(s13);

        Student s14 = new Student();
        s14.setName("十四");
        s14.setAge(23);
        s14.setId(14);

        students.add(s14);

        Student s15 = new Student();
        s15.setName("十五");
        s15.setAge(20);
        s15.setId(15);

        students.add(s15);



        Map map = new HashMap<>();
        map.put("code",0);//默认必须是0 不然不显示
        map.put("msg","写啥都行");
        map.put("count",3);
        map.put("data",students);

        String s = JSON.toJSONString(map);//使用alibaba的转换
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}