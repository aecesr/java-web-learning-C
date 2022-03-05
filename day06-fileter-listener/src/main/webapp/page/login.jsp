<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Created by IntelliJ IDEA.
  User: 小曹同学
  Date: 2022/3/4
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>登录成功了</h1>
<%
    HttpSession session1=request.getSession();
    session1.setAttribute("user","zhangsan");
%>
<a href="../index.jsp">点击去主页</a>
</body>
</html>
