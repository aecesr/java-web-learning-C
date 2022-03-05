package com.chl.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @program: java-web-learning-C
 * @description: 登陆验证过滤器
 * @Author: 曹红亮
 * @create: 2022-03-04 09:18
 **/
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    String msg="";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //登录状态校验逻辑代码

        //将servletrequest对象转为HttpServletRequest对象
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        String[] urls={"/login.jsp","/img/","/css/","/js","/loginservlet","register.jsp","/registerServlet","/verifyCodeServlet","*.jpg"};
        String url=request.getRequestURI().toString();
        for (String u : urls) {
            if (url.contains(u)) {
                filterChain.doFilter(request,servletResponse);
                return;
            }
        }
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            //登录过了，放行
            filterChain.doFilter(request, servletResponse);

        } else {
            //没有登录,调到登录界面
            String msg = "当前没有用户登录";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/login.jsp").forward(request,servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
