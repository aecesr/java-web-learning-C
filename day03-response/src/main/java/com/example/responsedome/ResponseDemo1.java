package com.example.responsedome;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
/*
 * @description: ResponseDemo响应练习，设置响应头，重定向
 * @author 曹红亮
 * @date 2022/2/25 8:41
 */
@WebServlet(urlPatterns ="/responseDemo1")
public class ResponseDemo1 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseDemo1...");
//        设置状态码为302
        resp.setStatus(302);
//        设置响应头
//        resp.setHeader("location","/responseDemo2");
        req.setAttribute("msg","heelo response");
//       简单的写法，重定向，可以跨域
//        resp.sendRedirect("http://www.baidu.com");
        resp.setHeader("msg","hello");
//        Object msg=req.getAttribute("mag");
        req.getRequestDispatcher("/responseDemo2").forward(req,resp);
//

    }

}