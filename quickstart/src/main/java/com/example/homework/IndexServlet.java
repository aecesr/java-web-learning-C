package com.example.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/27 11:28
 */
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("1111");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book[] books = {
                new Book("JAVA", "03-01.jpg", "大神"),
                new Book("javaweb", "03-02.jpg", "大神"),
                new Book("javaweb", "03-03.jpg", "大神")
        };
        List<Book> bookList = Arrays.asList(books);
        req.setAttribute("bookList",bookList);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
        resp.sendRedirect("index.jsp");
    }
}
