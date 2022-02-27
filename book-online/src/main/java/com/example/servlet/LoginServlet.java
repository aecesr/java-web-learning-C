package com.example.servlet;

import com.example.entity.User;
import com.example.service.UserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/24 17:28
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        取得表单参数
        String account=req.getParameter("account");
        String password=req.getParameter("password");
        UserService UserService = new UserService();
//        获得用户列表数据
        ServletContext sc=this.getServletContext();
        List<User> userList= (List<User>) sc.getAttribute("userList");
//        传数据到UserService
        UserService.setUserList(userList);
//        调用登陆功能
        User user = UserService.signIn(account,password);
        if (user != null) {
//            登陆成功
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
//            重新定向
            resp.sendRedirect("/index");
        } else {
//            登陆失败，设置响应的响应类型和字符集
            resp.setContentType("text/html;charset=utf-8");
            resp.setCharacterEncoding("UTF-8");
//            获得response的对象字符输出流
            PrintWriter out = resp.getWriter();
//            输出js脚本，弹出登陆失败信息，重新定向到login页面
            out.print("<script>alert('账号密码输入错误');location.href='/login';</script>");
        }
    }
}
