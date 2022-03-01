<%--
  Created by IntelliJ IDEA.
  User: 小曹同学
  Date: 2022/3/1
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录结果</title>
</head>
<body>
<h2>${msg}</h2>
<h2><% request.getAttribute("msg"); %></h2>
</body>
</html>
