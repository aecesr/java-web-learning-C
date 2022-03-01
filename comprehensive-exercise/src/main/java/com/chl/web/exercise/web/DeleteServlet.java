package com.chl.web.exercise.web;

import com.chl.web.exercise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        brandService.delete(Integer.parseInt(id));

        response.sendRedirect("/index");
    }
}
