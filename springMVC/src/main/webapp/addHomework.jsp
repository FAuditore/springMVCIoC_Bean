<%--
  Created by IntelliJ IDEA.
  User: FAuditore
  Date: 2020/3/13
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加作业</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="choose" align="center">
    <form action="${pageContext.request.contextPath}/addHomework" method="post">
        <table style="line-height: 40px">
            <tr>
                <th style="font-size: 30px">作业标题:</th>
                <td><input style="font-size: 20px" type="text" name="title" ></td>
            </tr>
            <tr>
                <th style="font-size: 30px">作业内容:</th>
                <td><input style="font-size: 20px" type="text" name="content" ></td>
            </tr>

            <tr align="center">
                <td><input class="option" type="reset" value="清空"></td>
                <td><input class="option" type="submit" value="添加"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
