<%@ page import="java.util.List" %>
<%@ page import="com.example.homework.Book" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
    <style >
        *{
            margin: 0;
            padding: 0;
        }
        .contaoner {
            width: 80%;
            margin: 0 auto;
            background-color: #ddd;
            display: flex;
            padding: 10px 10px 10px 10px;
            flex-wrap: wrap;
        }

        .box {
            flex: 0 0 20%;
            height: 280px;
            margin: 0 auto;;
            background-color: #fff;
            float: left;

        }
        .box p {
            text-align: center;
        }

        .box img {
            width: 100%;
            height: 80%;

        }
        a{
            text-decoration:none;
        }
    </style>
</head>
<body>
<h1>登录</h1>
<br>

<%
    String username = (String) request.getSession().getAttribute("username");
    if (username != null) {
        pageContext.setAttribute("username", username);
%>
${username}
<%
} else {

%>
<h3><a href="${pageContext.request.contextPath}/">去登陆</a></h3>
<%
}
%>
<hr>
<h2>图书信息</h2>
<%
    List<Book> bookList= (List<Book>) request.getAttribute("bookList");
    pageContext.setAttribute("size",bookList.size());
%>
一共${size}本书
<div class="contaoner">
    <%
        for (Book book : bookList) {
            pageContext.setAttribute("book",book);
    %>
    <div class="box">
        <img src="/imges/${book.cover}" alt="">
        <p>${book.name}</p>
        <p>${book.author}</p>
    </div>
    <%
        }

    %>
</div>
<a href="#">Hello Servlet</a>
</body>
</html>