package com.chl.web.exercise.web;

import com.chl.web.exercise.entity.User;
import com.chl.web.exercise.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/checkServlet")
public class checkServlet extends HttpServlet {
    private  final  UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        User user=User.builder().username(userName).build();
//        user ==null?true:false;
        boolean flag=userService.Check(user);
        System.out.println(flag);
        response.getWriter().write(String.valueOf(flag));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
