<%--
  Created by IntelliJ IDEA.
  User: FAuditore
  Date: 2020/3/13
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="choose">
    <form action="${pageContext.request.contextPath}/addStudent" method="post">
        <table style="line-height: 40px">
            <tr>
                <th style="font-size: 30px">学生姓名:</th>
                <td><input style="font-size:20px" type="text" name="name" maxlength="20"></td>
            </tr>
            <tr align="center">
                <th><input class="option" type="reset" value="清空"></th>
                <td><input class="option" type="submit" value="添加"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
