package com.example.responsedome;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: ResponseDome
 * @description: Response响应练习，重定向
 * @Author: 曹红亮
 * @create: 2022-02-25 08:53
 **/
@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseDemo2被访问。。。");
//        设置状态码为302：重定向
//        resp.setStatus(302);
//        设置响应头
//        resp.setHeader("location","responseDemo1");
//        通过request域传递数据
//        req.getSession().setAttribute("mas","hello response");
        ServletContext servletContext = req.getServletContext();
        Object msg=servletContext.getAttribute("a");
        System.out.println(msg);

    }


}
