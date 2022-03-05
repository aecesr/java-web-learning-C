package com.chl.web.Service;

import com.alibaba.fastjson.JSON;
import com.chl.web.entity.Brand;
import com.chl.web.entity.PageBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
   private final BrandService brandService=new BranServiceImpl();

    public void selectAll(HttpServletRequest req,HttpServletResponse resp)throws  ServletException,IOException{
        //调用service查询
        List<Brand> brands = brandService.selectAll();
//        转为JSON
        String s = JSON.toJSONString(brands);
//        写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }
    public void add(HttpServletRequest req,HttpServletResponse resp)throws  ServletException,IOException{
        //        接受品牌数据
        BufferedReader br = req.getReader();
//        json字符串
        String s = br.readLine();
        //        转为brand对象
        Brand brand = JSON.parseObject(s, Brand.class);
        //        调用service添加
        brandService.add(brand);
//        响应成功
        resp.getWriter().write("success");
    }
    public void deleteByIds(HttpServletRequest req,HttpServletResponse resp)throws  ServletException,IOException{
//        接收数据[1,2,3]
        BufferedReader br = req.getReader();

        String params=br.readLine();
//        转为int[]
        int[] ids= JSON.parseObject(params,int[].class);
//        调用service添加
        brandService.deleteByIds(ids);
//        响应成功
        resp.getWriter().write("success");
    }
    public void selectByPage(HttpServletRequest req,HttpServletResponse resp)throws  ServletException,IOException{
//        接收当前页码和每页展示条数
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");
//        将字符串参数转化为整型
        int currentPage = Integer.parseInt(currentPageStr);
        int pageSize = Integer.parseInt(pageSizeStr);
//        调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
//        转为json
        String s = JSON.toJSONString(pageBean);
//        响应
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    public void selectByPageAndCondition(HttpServletRequest req,HttpServletResponse resp)throws  ServletException,IOException{
//        接收当前页码和每页展示条数
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");
        //        将字符串参数转化为整型
        int currentPage = Integer.parseInt(currentPageStr);
        int pageSize = Integer.parseInt(pageSizeStr);
//        获取查询条件对象
        BufferedReader br = req.getReader();
        String s1 = br.readLine();
//        转为brand对象
        Brand brand = JSON.parseObject(s1, Brand.class);
        //        调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);
        //        转为json
        String s = JSON.toJSONString(pageBean);
//        响应
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }

}

