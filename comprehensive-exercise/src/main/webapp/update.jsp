<%@ page import="com.chl.web.exercise.entity.Brand" %><%--
  Created by IntelliJ IDEA.
  User: 小曹同学
  Date: 2022/3/1
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    title{
        text-align: center;
        width: 100%;
    }

    h1{
        font-size: 50px;
        color: #2D2F36;
        text-transform: uppercase;
        font-weight: 300;
        text-align: center;
        margin-bottom: 15px;
        font-family: "Adobe 宋体 Std L";
        font-weight: bold;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>修改品牌页面</title>

    <style>
        table {
            border: 1px solid #ccc;
        }

        table td {
            border: none;
            padding: 10px;
        }
         body {
             background: url("images/bg.jpg") no-repeat 0 0;
             background-size: 100% 100%;
         }

        .container {
            width: 85%;
            margin: 0 auto;
            background-color: #fff;
            padding: 30px;
            height: 100vh;
            border-radius: 8px;
        }

        table {
            border-collapse: collapse;
            margin: 20px;
        }

        table td {
            border: 1px solid #ccc;
            padding: 5px;
        }

        table td a {
            text-decoration: none;
            color: #4A9BF5;
        }

        table td a:hover {
            color: #D86736;
        }

        input[type="button"], input[type="submit"] {
            padding: 7px 15px;
            background-color: #3c6db0;
            text-align: center;
            border-radius: 5px;
            overflow: hidden;
            min-width: 80px;
            border: none;
            color: #FFF;
            box-shadow: 1px 1px 1px rgba(75, 75, 75, 0.3);
        }

        input[type="button"]:hover, input[type="submit"]:hover {
            background-color: #5a88c8;
        }

        input[type="button"]:active, input[type="submit"]:active {
            background-color: #5a88c8;
        }

        input[type="text"] {
            padding: 5px 10px;
            outline: none;
            border: none;
            color: #333;
        }

        textarea, input[type="text"] {
            border: 1px solid #ccc;
            text-align: left;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<%
    Brand brand = (Brand) request.getAttribute("brand");
%>
<h1>修改品牌</h1>
<div class="container">
    <hr>
    <form action="${pageContext.request.contextPath}/updateBrand" method="post">
        <%--隐藏域，提交id--%>
        <input type="hidden" name="id" value="<%=brand.getId()%>">
        <table>
            <tr>
                <td>
                    <label for="brandName">
                        品牌名称
                    </label>
                </td>
                <td><input type="text" name="brandName" value="<%=brand.getBrandName()%>" id="brandName"></td>
            </tr>

            <tr>
                <td>
                    <label for="companyName">
                        企业名称
                    </label>
                </td>
                <td><input type="text" name="companyName" value="<%=brand.getCompanyName()%>" id="companyName"></td>
            </tr>

            <tr>
                <td>
                    <label for="ordered">
                        排序
                    </label>
                </td>
                <td><input type="text" name="ordered" value="<%=brand.getOrdered()%>" id="ordered"></td>
            </tr>

            <tr>
                <td>
                    <label for="description">
                        描述信息
                    </label>
                </td>
                <td>
                        <textarea name="description" rows="10" cols="50" id="description">
                              <%=brand.getDescription()%>
                        </textarea>
                </td>
            </tr>

            <tr>
                <td> 状态</td>
                <td>
                    <%
                        if (brand.getStatus() == 1) {
                    %>
                    <input name="status" type="radio" id="ok" value="1" checked>
                    <label for="ok">
                        启用
                    </label>
                    <input name="status" type="radio" id="no" value="0">
                    <label for="no">
                        禁用
                    </label>
                    <%
                    } else {
                    %>
                    <input name="status" type="radio" id="ok" value="1">
                    <label for="ok">
                        启用
                    </label>
                    <input name="status" type="radio" id="no" value="0" checked>
                    <label for="no">
                        禁用
                    </label>
                    <%
                        }
                    %>
                </td>
            </tr>
        </table>

        <div style="padding-left: 20px;">
            <input type="submit" value="提交">
        </div>
    </form>

</div>

</body>
</html>