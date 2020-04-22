package servlet;

import jdbc.StudentHomeworkJdbc;
import model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SubmitHomework
 *
 * @author wangkm
 * @date 2020-03-05
 * @since 0.0.1
 */
@WebServlet("/submitHomework")
public class SubmitHomework extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("submitHomework.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId(Integer.parseInt(req.getParameter("student_id")));
        studentHomework.setHomeworkId(Integer.parseInt(req.getParameter("homework_id")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());// new Date()为获取当前系统时间
        studentHomework.setCreateTime(date);
        if(new StudentHomeworkJdbc().submitHomework(studentHomework)){
            resp.getWriter().println("<script>alert(\"OK!\");</script>") ;
        }
    }
}
