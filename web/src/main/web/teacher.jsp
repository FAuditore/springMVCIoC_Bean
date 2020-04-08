<%--
  Created by IntelliJ IDEA.
  User: FAuditore
  Date: 2020/3/13
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="choose">
    <a href="${pageContext.request.contextPath}/addHomework"target="_blank"><button type="button" >添加作业</button></a>
    <br>
    <a href="${pageContext.request.contextPath}/addStudent"target="_blank"><button type="button" >添加学生</button></a>
    <br>
    <a href="list.jsp"target="_blank"><button type="button" >查询学生作业</button></a>
</div>
</body>
</html>
