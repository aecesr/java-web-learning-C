package com.chl.web.exercise.web;

import com.chl.web.exercise.entity.User;
import com.chl.web.exercise.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.io.IOException;
@Slf4j
@WebServlet("/register")
public class registerServlet extends HttpServlet {
    private UserService userService= new UserService();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String register = request.getParameter("register");
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");

//        log.info(register);
        // 程序生成的验证码，从Session获取
        HttpSession session = request.getSession();
        String os = (String) session.getAttribute("os");
        response.setContentType("text/html;charset=utf-8");


        // 忽略大小写比对
        if (!os.equalsIgnoreCase(register)) {
            //验证码错误，跳回注册页面
            request.setAttribute("username", "");
            request.setAttribute("password", "");

            response.getWriter().write("<script>alert('验证码错误');location='/register.html';</script>");

        } else {
            log.info("---------------------------------------------");
            User user=new User();
            //2. 调用service 注册
            if (userName=="" || passWord==""){
                response.getWriter().write("<script>alert('账户或密码不能为空');location='/register.html';</script>");
            }else {
                user.setUsername(userName);
                user.setPassword(passWord);
            }
            boolean flag = userService.register(user);

            //3. 判断注册成功与否
            if (flag) {
                //注册成功，跳转登陆页面
                response.getWriter().write("<script>alert('注册成功');location='/login.html';</script>");
            }else {
                //用户名已存在，注册失败，跳回注册页面
                response.getWriter().write("<script>alert('用户名已存在');location='/register.html';</script>");
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
