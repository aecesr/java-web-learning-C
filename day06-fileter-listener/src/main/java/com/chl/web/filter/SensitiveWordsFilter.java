package com.chl.web.filter;

import jakarta.servlet.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-web-learning-C
 * @description: 敏感词过滤
 * @Author: 曹红亮
 * @create: 2022-03-04 16:17
 **/
//@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private final List<String> list=new ArrayList<>();
    private final String menthodName="getParameter";
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("SensitiveWordsFilter初始化");
        try {
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            InputStreamReader  in = new InputStreamReader(new FileInputStream(realPath),"UTF-8");
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {

                list.add(line);
            }
            br.close();
            System.out.println(list+"这是value");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("SensitiveWordsFilter销毁");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest proxyReq=(ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (menthodName.equals(method.getName())) {
                    String value=(String) method.invoke(req,args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value=value.replaceAll(str,"***");
                            }
                        }
                    }
                    System.out.println("加密后内容"+value);
                    return value;
                }
                return method.invoke(req,args);
            }
        });
        filterChain.doFilter(proxyReq,resp);
    }
}
