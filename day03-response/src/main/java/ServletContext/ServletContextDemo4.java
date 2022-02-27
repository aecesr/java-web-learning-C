package ServletContext;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/path")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    得到servletContext
        ServletContext servletContext = this.getServletContext();
//        访问webapp目录下的txt
        String bPath = servletContext.getRealPath("/b.txt");
        System.out.println(bPath);
//        访问web-inf目录下的txt
        String cPath = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println(cPath);
//        访问src下的txt
        String aPath = servletContext.getRealPath("/WEB-INF/class/top/hlcao/servlet/a.txt");
        System.out.println(aPath);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
