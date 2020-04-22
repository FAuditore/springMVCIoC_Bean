package servlet;

import jdbc.StudentHomeworkJdbc;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student s = new Student();
        s.setName(req.getParameter("name"));
        if(new StudentHomeworkJdbc().addStudent(s)){
            resp.getWriter().println("<script>alert(\"OK!\");</script>") ;
        }
    }
}
