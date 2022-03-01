package com.chl.web.exercise.web;

import com.chl.web.exercise.entity.Brand;
import com.chl.web.exercise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebServlet("/selectById")
public class SelectByIdServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收id
        String id = request.getParameter("id");
        //调用service查询
        Brand brand = brandService.selectById(Integer.parseInt(id));
        //存储到request中
        request.setAttribute("brand", brand);
        //转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
