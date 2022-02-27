package com.example.servlet;

import com.example.entity.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/24 11:11
 */
@WebServlet(urlPatterns ="/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获得各个servlet共享的对象
        ServletContext sc = this.getServletContext();
//        取得全局应用对象中的变量
        List<Book> bookList= (List<Book>) sc.getAttribute("bookList");
//        存入request
        req.setAttribute("bookList",bookList);
        resp.setContentType("text/plain;charset=utf-8");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
