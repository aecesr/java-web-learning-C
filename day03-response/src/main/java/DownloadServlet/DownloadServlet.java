package DownloadServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @program: ResponseDome
 * @description:
 * @Author: 曹红亮
 * @create: 2022-02-25 16:52
 **/
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求参数文件名称
        String filename = req.getParameter("filename");
//          找到文件的服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
//        永字节流输入
        InputStream is = new FileInputStream(realPath);
//        定义一个时间参数用来作下载文件的filename

        Date date =new Date();

//        设置响应头的打开方式
        resp.setHeader("content-disposition", "attachment;filename=" + date.getTime()+".jpg");
//            定义一个和输出流
        ServletOutputStream sos = resp.getOutputStream();
//            定义一个缓冲数组 最好不大不小，太大出错全完，太小太慢
        byte[] buff = new byte[1024 * 8];
        int len;
//        使用循环读字节出来，不是-1代表是成功的
        while ((len = is.read(buff)) != -1) {
//            就可以输出字符流
            sos.write(buff, 0, len);
        }
//        关闭流
        sos.close();
//        关闭流
        is.close();

    }
}
