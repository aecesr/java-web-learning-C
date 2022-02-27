package com.web.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/27 10:41
 */
public class ServletDemo1 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我进来啦");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Demo1");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
