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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "LayuiServlet",urlPatterns = "/LayuiServlet")
public class LayuiServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        //自己创建一个layui后台的json格式
        List<Student> students = new ArrayList<>();
        Student s1 = new Student();
                s1.setName("小卤蛋");
                s1.setAge(23);
                s1.setId(001);
                s1.setBrithday(new Date());
                s1.setShen(false);
                students.add(s1);

        Student s2 = new Student();
                s2.setName("凯爹");
                s2.setAge(33);
                s2.setId(002);
                s2.setShen(true);
                String bdate = "2012-09-18 22:12:32";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date bDate = null;
                try{
                    bDate = simpleDateFormat.parse(bdate);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                s2.setBrithday(bDate);
        students.add(s2);

        Student s3 = new Student();
                s3.setName("大飞飞");
                s3.setAge(21);
                s3.setId(003);
                s3.setShen(false);
        s3.setBrithday(new Date());
        students.add(s3);

        Map map = new HashMap<>();
        map.put("code",0);//默认必须是0 不然不显示
        map.put("msg","写啥都行");
        map.put("count",3);
        map.put("data",students);
        System.out.println("students = " + students);

        String s = JSON.toJSONString(map);//使用alibaba的转换
        System.out.println("s = " + s);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}