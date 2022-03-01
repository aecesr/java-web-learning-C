package com.example.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @program: java-web-learning-C
 * @description:
 * @Author: 曹红亮
 * @create: 2022-02-28 11:02
 **/
@WebServlet("/servletB")
@Slf4j
public class ServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies=req.getCookies();
        for (Cookie cookie : cookies) {
            String name=cookie.getName();
            if ("username".equals(name)) {
                String value=cookie.getValue();
                log.info("name:"+value);
//                System.out.println("name"+value);
                log.info(value);

                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
