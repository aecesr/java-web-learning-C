package com.example.responsedome;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: ResponseDome
 * @description: response对象练习，向客户端返回字符数据
 * @Author: 曹红亮
 * @create: 2022-02-25 13:44
 **/
@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/txt;charset=UTF-8");
        String info="javaweb开发";

        PrintWriter out = resp.getWriter();
        out.println(out);
        out.flush();
        out.close();
    }
}


