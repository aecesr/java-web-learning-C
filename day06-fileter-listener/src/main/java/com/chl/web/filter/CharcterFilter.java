package com.chl.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: java-web-learning-C
 * @description: 编码过滤器
 * @Author: 曹红亮
 * @create: 2022-03-04 16:12
// **/
//@WebFilter("/*")
public class CharcterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharcterFilter初始化");
    }

    @Override
    public void destroy() {
        System.out.println("CharcterFilter销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        resp.setContentType("text/html;charset=utf-8");
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            request.setCharacterEncoding("utf-8");
        }
        filterChain.doFilter(servletRequest,resp);
    }
}
