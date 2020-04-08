<%@ page import="model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="jdbc.StudentHomeworkJdbc" %>
<%@ page import="model.Homework" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeworkList</title>
</head>
<body>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
        <td>提交</td>
    </tr>
    <%
        List<Homework> list = new StudentHomeworkJdbc().findAll();
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
            for (Homework h : list){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=h.getId()%></td>
        <td><%=h.getTitle()%></td>
        <td><%=h.getContent()%></td>
        <td><%=h.getCreate_time()%></td>
        <td><a href="${pageContext.request.contextPath}/submitHomework"><input type="submit"value="提交作业"/></a></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
