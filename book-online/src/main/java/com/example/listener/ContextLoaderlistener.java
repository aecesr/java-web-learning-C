package com.example.listener;

import com.example.entity.Book;
import com.example.entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @description:
 * @author 曹红亮
 * @date 2022/2/24 22:21
 */
@WebListener
public class ContextLoaderlistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动");
//        创建并生成用户数据列表
        List<User> userList = new ArrayList<>();
        User[] users = {
                new User(1, "aaa@qq.com", "e10adc3949ba59abbe56e057f20f883e", "寥寥星河", "user1.jpg", "江苏南京", LocalDate.of(2022, 6, 15)),
                new User(2, "bbb@qq.com", "e10adc3949ba59abbe56e057f20f883e", "小幸运", "user2.jpg", "浙江杭州", LocalDate.of(2021, 12, 28)),
                new User(3, "ccc@qq.com", "e10adc3949ba59abbe56e057f20f883e", "往后余生", "user3.jpg", "湖北武汉", LocalDate.of(2020, 8, 29))
        };
        userList = Arrays.asList(users);
//        创建并生成图书数据列表
        List<Book> bookList = new ArrayList<>();
        Book[] books = {
                new Book(1, "漫长的婚约", "book1.jpg", "[法] 塞巴斯蒂安"),
                new Book(2, "庸人自扰", "book2.jpg", "[英]戴伦•麦加维"),
                new Book(3, "绿山墙的安妮", "book3.jpg", "[美]理查德·耶茨"),
                new Book(4, "敌人与邻居", "book4.jpg", "[英]伊恩·布莱克"),
                new Book(5, "哀伤纪", "book5.jpg", "钟晓阳"),
                new Book(6, "漫长的婚约", "book1.jpg", "[法] 塞巴斯蒂安"),
                new Book(7, "庸人自扰", "book2.jpg", "[英]戴伦•麦加维"),
                new Book(8, "绿山墙的安妮", "book3.jpg", "[美]理查德·耶茨"),
                new Book(9, "敌人与邻居", "book4.jpg", "[英]伊恩·布莱克"),
                new Book(10, "哀伤纪", "book5.jpg", "钟晓阳"),
        };
        bookList = Arrays.asList(books);
//        获得全局变量
        ServletContext servletContext= sce.getServletContext();
//        设置全局变量属性，将用户和图书列表数据计入，整个应用可以共享
        servletContext.setAttribute("userList",userList);
        servletContext.setAttribute("bookList",bookList);
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁");
    }
}
