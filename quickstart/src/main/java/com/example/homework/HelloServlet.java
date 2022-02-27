package com.example.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/27 11:28
 */
@WebServlet(urlPatterns = "/login")
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("1111");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.jsp");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "111".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("index.html");
        } else {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<script>alert(\"登陆失败\");location.href='/'</script>");
        }
    }
}