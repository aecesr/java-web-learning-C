package com.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/27 10:41
 */
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("我进来啦");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }
}
