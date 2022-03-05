package com.chl.web.exercise.web;

import com.alibaba.fastjson.JSON;
import com.chl.web.exercise.entity.Brand;
import com.chl.web.exercise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/newBrand")
public class NewBrandServlet extends HttpServlet {
    private final BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        使用缓冲字符输入流来获取请求体数据
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = request.getReader();
        while ((line = br.readLine()) != null) {
            json.append(line);
        }
//        将json字符串转为java对象
        Brand brand= JSON.parseObject(json.toString(),Brand.class);
//        调用service添加
        System.out.println(brand);
        brandService.add(brand);

        //响应成功
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
