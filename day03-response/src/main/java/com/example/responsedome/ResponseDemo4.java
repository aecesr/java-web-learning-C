package com.example.responsedome;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @program: ResponseDome
 * @description: 响应，输出字节数据
 * @Author: 曹红亮
 * @create: 2022-02-25 14:07
 **/
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
//        PrintWriter out = resp.getOutputStream();
//        String json = "{\"姓名\":\"张三\",\"年龄\": 23,\"学校\":\"南京工业职业技术大学\"" +
//                "}";
//        out.write(json.getBytes(StandardCharsets.UTF_8));

    }
}
