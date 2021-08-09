package com.hp.controller;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ShenServlet",urlPatterns = "/ShenServlet")
public class ShenServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        String shen = req.getParameter("shen");
        System.out.println("shen = " + shen);
        Map map = new HashMap<>();
        map.put("code",0);//默认必须是0 不然不显示
        map.put("msg","修改成功");
        map.put("shen","神仙");


        String s = JSON.toJSONString(map);//使用alibaba的转换
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
