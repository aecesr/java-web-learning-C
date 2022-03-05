package com.chl.web.exercise.web;

import com.alibaba.fastjson.JSON;
import com.chl.web.exercise.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: java-web-learning-C
 * @description: post方式提交表单
 * @Author: 曹红亮
 * @create: 2022-03-03 08:28
 **/
@WebServlet("/login2")
public class PostFormLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User(username,password);
        PrintWriter out=resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        out.print(JSON.toJSONString(user));
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
