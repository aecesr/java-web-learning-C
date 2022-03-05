package com.chl.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @program: java-web-learning-C
 * @description: 过滤器demo
 * @Author: 曹红亮
 * @create: 2022-03-04 08:30
 **/
//@WebFilter("/*")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器1初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器1被执行");

        //放行,放开本应该访问的资源
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器1放行");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器1被销毁");
    }
}
