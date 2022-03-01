package com.chl.web.exercise.web;

import com.chl.web.exercise.entity.User;
import com.chl.web.exercise.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet("/login")
@Slf4j
public class LoginServlet extends HttpServlet {
    private UserService userService= new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            获得用户名和密码
        String cusername = request.getParameter("username");
        String cpassword = request.getParameter("password");
        Object rememberme = request.getParameter("rememberme");
        System.out.println(rememberme);
//        调用service登陆
        User user= userService.login(cusername,cpassword);
//          判断

        if (user != null) {
            //                创建cookie对象
            Cookie username = new Cookie("username", cusername);
            Cookie password = new Cookie("password", cpassword);
//            非空
            if ("on".equals(rememberme)) {

//                设置存活时间
                username.setMaxAge(60 * 60 * 24 * 7);
                password.setMaxAge(60 * 60 * 24 * 7);
//                        发送cookie
                response.addCookie(username);
                response.addCookie(password);
            } else {
                username.setMaxAge(0);
                password.setMaxAge(0);
                //                        发送cookie
                response.addCookie(username);
                response.addCookie(password);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/index");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('用户名或密码错误');location='/login.html';</script>");
        }
    }
}
