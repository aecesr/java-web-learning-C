package ServletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @program: 通过ServletContext获取mime类型
 * 1、获取MIME类型
 * 2、共享数据
 * 3、获取服务器的真实路径
 * @description:
 * @Author: 曹红亮
 * @create: 2022-02-25 16:22
 **/
@WebServlet("/context2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        String fileName="a.jpg";
//        获取文件类型
        String mimeType = context.getMimeType(fileName);
        System.out.println(mimeType);



    }
}
