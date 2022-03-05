package com.chl.web.Service;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    public void selectAll(HttpServletRequest req,HttpServletResponse resp)throws  ServletException,IOException{
        System.out.println("user selectALL");
    }
    public void add(HttpServletRequest req,HttpServletResponse resp)throws  ServletException,IOException{
        System.out.println("user add....");
    }
}
