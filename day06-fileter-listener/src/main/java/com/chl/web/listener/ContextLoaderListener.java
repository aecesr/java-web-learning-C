package com.chl.web.listener;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class ContextLoaderListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private static Map<String,Object> sessionMap;

    public ContextLoaderListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener初始化，正在加载。。。。");
        sessionMap= new HashMap<>(8);
        sce.getServletContext().setAttribute("sessionMap",sessionMap);
    }



    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener销毁，释放资源");

    }


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated,创建了新的会话。。");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionCreated,销毁了会话。。");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        HttpSession session=sbe.getSession();
        System.out.println(session.getAttribute("username")+"上线了。。");
        sessionMap.put(session.getId(),session.getAttribute("username"));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        HttpSession session=sbe.getSession();
        System.out.println(session.getAttribute("username")+"下线了。。");
        sessionMap.remove(session.getId(),session.getAttribute("username"));
    }
}
