package com.chl.web.Service;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求路径
        StringBuffer url= req.getRequestURL();
//        获取最后一段路径，方法名
        int index = url.lastIndexOf("/");
        System.out.println(index+"/之后的一段路径");//  22/之后的一段路径

        String menthodName = url.substring(index + 1);
        System.out.println(menthodName+"取出来的子串"); //selectByPageAndCondition取出来的子串
//执行方法
//        获取BaseServlet /UserServlet字节码对象Class
        Class<? extends BaseServlet> cls = this.getClass();
//        获取方法，menthod对象
        try {
            Method method = cls.getMethod(menthodName, HttpServletRequest.class, HttpServletResponse.class);
//            执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
