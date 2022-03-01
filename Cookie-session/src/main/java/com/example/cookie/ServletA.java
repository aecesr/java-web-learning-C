package com.example.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: java-web-learning-C
 * @description: Cookie练习
 * @Author: 曹红亮
 * @create: 2022-02-28 10:52
 **/

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie = new Cookie("username","zhangsan");
        //对cookie持久化
        cookie.setMaxAge(60);
        //通过response发送cookie
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
