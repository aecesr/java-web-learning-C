<%@ page import="com.example.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 小曹同学
  Date: 2022/2/24
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user");
    pageContext.setAttribute("user", user);
%>
<ul>
    <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
    <li><a href="#">读书</a></li>
    <li><a href="#">音乐</a></li>
    <li><a href="#">小组</a></li>
    <li><a href="#">同城</a></li>
    <li><a href="#">FM</a></li>
    <li><a href="#">时间</a></li>
    <li><a href="#">更多</a></li>
</ul>
<ul>
    <%
        if (user != null) {
    %>
    <li><a href="${pageContext.request.contextPath}/user">
        <img src="${pageContext.request.contextPath}/images/${user.avatar}" alt="" class="avatar">
    </a></li>
    <li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
    <%
    } else {

    %>
    <a href="${pageContext.request.contextPath}/login">去登陆</a>

    <%
        }
    %>
</ul>
</body>
</html>
