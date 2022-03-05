package com.chl.web.exercise.web;

import java.io.*;
import java.util.List;

import com.chl.web.exercise.entity.Brand;
import com.chl.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

@WebServlet("/index")
@Slf4j
public class IndexServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Brand> brands = brandService.selectAll();
        req.setAttribute("brands",brands);
        req.getRequestDispatcher("/brand.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }


}