package servlet;

import jdbc.StudentHomeworkJdbc;
import model.Homework;
import model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addHomework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addHomework.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        Homework homework = new Homework();

        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());// new Date()为获取当前系统时间
        homework.setCreate_time(date);
        if(new StudentHomeworkJdbc().addHomework(homework)){
            resp.getWriter().println("<script>alert(\"OK!\");</script>") ;
        }
    }
}
