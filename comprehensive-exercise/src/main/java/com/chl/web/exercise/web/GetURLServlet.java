package com.chl.web.exercise.web;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/param")
public class GetURLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //取得参数部分字符串
        String str = request.getQueryString();
        //按&分割成若干组
        String[] params = str.split("&");
        System.out.println(params);
        Map<String, String> map =new HashMap<>(4);
        for (String s : params) {
            // 每组按=分割，得到参数名和参数值
            int a=1;
            String[] split=s.split("=");
            //如果参数值包含编码后的中文，需要解码
            if (split[a].contains("%")) {
                //URLDecoder解码
                split[a] = java.net.URLDecoder.decode(split[a],"utf-8");
            }
            map.put(split[0],split[1]);
            a+=2;
        }
        response.getWriter().write(JSON.toJSONString(map));
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
