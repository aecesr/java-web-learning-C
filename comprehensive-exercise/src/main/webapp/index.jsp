<%@ page import="com.chl.web.exercise.entity.User" %>
<%@ page import="com.chl.web.exercise.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>品牌主页</title>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
<section>
    <%
        User user = (User) request.getSession().getAttribute("user");
        List<Brand> brands = (List<Brand>) request.getAttribute("brands");
    %>
    <!--for demo wrap-->
    <h1><%=user.getUsername()%>,欢迎您</h1>
    <div class="tbl-header">

        <hr>
        <table >
            <thead>
            <tr>
                <th>序号</th>
                <th>品牌名称</th>
                <th>企业名称</th>
                <th>排序</th>
                <th>品牌介绍</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table >
            <tbody>
            <%
                for (Brand brand : brands) {
            %>
            <tr>
                <td><%=brand.getId()%>
                </td>
                <td><%=brand.getBrandName()%>
                </td>
                <td><%=brand.getCompanyName()%>
                </td>
                <td><%=brand.getOrdered()%>
                </td>
                <td><%=brand.getDescription()%>
                </td>
                <td>
                    <%
                        if (brand.getStatus() == 0) {
                    %>
                    禁用
                    <%
                    } else {
                    %>
                    启用
                    <%
                        }
                    %>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/selectById?id=<%=brand.getId()%>">修改</a>
                    <a href="${pageContext.request.contextPath}/delete?id=<%=brand.getId()%>">删除</a>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <input type="button" value="新增" id="add">
    </div>
</section>


<!-- follow me template -->
<div class="made-with-love">
    Made with
    <i>♥</i> by
    <a target="_blank" href="https://codepen.io/nikhil8krishnan">Nikhil Krishnan</a>
</div>
<script>
        document.getElementById("add").onclick = function () {
        location.href = "/addBrand.jsp";
    }
</script>
</body>
</html>

