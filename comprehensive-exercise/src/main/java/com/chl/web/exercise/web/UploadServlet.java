package com.chl.web.exercise.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Part part = request.getPart("file");
        //上传的文件大小
        long size = part.getSize();
        System.out.println("文件大小：" + size + "字节");

        System.out.println("=====================================================================");
        //获取文件上传的字符流
        InputStream inputStream = part.getInputStream();
        System.out.println(inputStream);

        //获取文件名字
        String fileN=part.getSubmittedFileName();
//        更改文件名字
//        String fileName=UUID.randomUUID() +part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
        System.out.println(fileN);
        ServletContext context = this.getServletContext();

        System.out.println(fileN);
        String realPath = context.getRealPath("upload/"+fileN);

        //进行文件存储
        part.write(realPath);
//
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("文件上传成功");
        out.flush();
        out.close();
    }
}
