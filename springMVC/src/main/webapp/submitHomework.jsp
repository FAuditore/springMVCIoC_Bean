<%--
  Created by IntelliJ IDEA.
  User: FAuditore
  Date: 2020/3/13
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="choose" align="center">
    <form action="${pageContext.request.contextPath}/submit" method="post">
        <table style="line-height: 40px">
            <tr>
                <th style="font-size: 30px">你的学号:</th>
                <td><input style="font-size: 20px" type="text" name="student_id" ></td>
            </tr>
            <tr>
            <th style="font-size: 30px">作业编号:</th>
            <td><input style="font-size: 20px" type="text" name="homework_id" ></td>
            </tr>
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
                <td><input class="option" type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

