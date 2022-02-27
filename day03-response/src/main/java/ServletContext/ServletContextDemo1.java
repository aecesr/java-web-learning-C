package ServletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: 两种方法获取ServletContextDemo1对象
 * @description:
 * @Author: 曹红亮
 * @create: 2022-02-25 16:19
 **/
@WebServlet("/context1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jakarta.servlet.ServletContext sc1 = req.getServletContext();
        jakarta.servlet.ServletContext sc2 = this.getServletContext();
        System.out.println(sc1==sc2);

    }
}
