package top.hlcao.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @program: ResponseDome
 * @description: 验证码
 * @Author: 曹红亮
 * @create: 2022-02-25 14:27
 **/
@WebServlet("/code")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        规定验证码的大小
        int width = 300;
        int height = 180;
//       创建一个在内存中存放验证码图片的对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        绘制图片
//        画笔对象
        Graphics g = image.getGraphics();
//        画画
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
//        绘制边框
        g.setColor(Color.black);
        g.drawRect(0, 0, width-1 , height-1);
        String str = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASFGHJKLZXCVBNM";

        Random random = new Random();
//        四位验证码
        for (int i = 1; i < 5; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            Font f=new Font("宋体" ,  2 ,  (int) ((Math.random()*61)+40));
            g.setFont(f);
            g.drawString(String.valueOf(ch), width / 5 * i, (int) ((Math.random()*40)+90));

        }
//        todo:绘制干扰线

        for (int i = 0; i < 20; i++) {
            int x= (int) (Math.random()*256);
            int y= (int) (Math.random()*256);
            int z= (int) (Math.random()*256);
            g.setColor(new Color(x, y, z));
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1, x2, y1, y2);
        }


//        验证码输出到页面
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
}
