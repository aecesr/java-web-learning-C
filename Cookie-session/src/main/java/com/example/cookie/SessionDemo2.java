package com.example.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @program: java-web-learning-C
 * @description:
 * @Author: 曹红亮
 * @create: 2022-02-28 13:57
 **/
@Slf4j
@WebServlet("/session2")
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
//        获取数据
        Object username=session.getAttribute("username");
        //打印
        log.info(String.valueOf(username));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
