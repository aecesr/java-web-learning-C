package com.chl.web.exercise.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

@WebServlet("/upload1")
@MultipartConfig
public class UploadImageServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("=================================================");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.setCharacterEncoding("utf-8");
//        //获取提交数据中的username
//        //运行效果
//        String account = request.getParameter("username");
//
//        Part part = request.getPart("file");
//        // 原文件名
//        System.out.println(part.getSubmittedFileName());
//
//        String fileName = "";
//
//        if (part.getContentType() != null) {
//            // 给文件改名
//            fileName = UUID.randomUUID() + part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
//            // 获取项目部署的绝对路径
//            ServletContext context = this.getServletContext();
//            // 文件上传最终的目录/文件名
//            String realPath = context.getRealPath("upload/" + fileName);
//            // 上传
//            part.write(realPath);
//        }.

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
        // 把上传图片的相对路径返回给客户端
        out.write("./upload/" + fileN);
        out.flush();
        out.close();







    }
}