package controller;

import model.Student;
import model.StudentHomework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import jdbc.StudentHomeworkJdbc;
import model.Homework;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentHomeworkJdbc.class);
    StudentHomeworkJdbc jdbc = (StudentHomeworkJdbc) applicationContext.getBean("jdbc");

    @RequestMapping(path = "showHomework",method = RequestMethod.GET)
        public ModelAndView showHomework(){
        List<Homework> list = new StudentHomeworkJdbc().findAll();
        return new ModelAndView("showHomework.jsp","list",list);
    }

    @RequestMapping(path = "showSubmit",method = RequestMethod.GET)
    public ModelAndView showSubmit(){
        List<Homework> list = new StudentHomeworkJdbc().findAll();
        return new ModelAndView("showSubmit.jsp","list",list);
    }

    @RequestMapping(path = "/addHomework",method = RequestMethod.POST)
    public String addHomework(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        Homework homework = new Homework();

        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());// new Date()为获取当前系统时间
        homework.setCreate_time(date);
        if(new StudentHomeworkJdbc().addHomework(homework)){
            String resp = "<script>alert(\"添加成功!\");</script>";
            return resp;
        }
        String resp = "<script>alert(\"添加失败!\");</script>";
        return resp;
    }

    @RequestMapping(path = "/addStudent",method = RequestMethod.POST)
    public String addStudent(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        Student s = new Student();
        s.setName(req.getParameter("name"));
        if(new StudentHomeworkJdbc().addStudent(s)){
            String resp = ("<script>alert(\"添加成功!\");</script>") ;
            return resp;
        }
        String resp = "<script>alert(\"添加失败!\");</script>";
        return resp;
    }

    @RequestMapping(path = "/submitHomework",method = RequestMethod.POST)
    public String submitHomework(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId(Integer.parseInt(req.getParameter("student_id")));
        studentHomework.setHomeworkId(Integer.parseInt(req.getParameter("homework_id")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());// new Date()为获取当前系统时间
        studentHomework.setCreateTime(date);
        if(new StudentHomeworkJdbc().submitHomework(studentHomework)){
          String resp = ("<script>alert(\"提交成功!\");</script>") ;
          return resp;
        }
        String resp = ("<script>alert(\"提交失败!\");</script>") ;
        return resp;
    }

}
