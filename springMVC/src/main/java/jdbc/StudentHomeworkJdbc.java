package jdbc;

import model.Homework;
import model.Student;
import model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {

    String url = "jdbc:mysql://127.0.0.1:3306/school";

    String allUrl = url + "?user=root&password=123456&serverTimezone=UTC";

    String sql =null;

    public static void main(String[] args){

    }
    public boolean addStudent(Student s){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sql ="INSERT INTO student (name) values (?)";
            Connection connection =  DriverManager.getConnection(allUrl);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,s.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean addHomework(Homework h){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sql ="INSERT INTO homework (title,content,create_time) values (?,?,?)";
            Connection connection =  DriverManager.getConnection(allUrl);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,h.getTitle());
            statement.setString(2,h.getContent());
            statement.setString(3,h.getCreate_time());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean submitHomework(StudentHomework sh){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sql ="INSERT INTO student_homework (student_id,homework_id,title,content,create_time) values (?,?,?,?,?)";
            Connection connection =  DriverManager.getConnection(allUrl);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,sh.getStudentId());
            statement.setInt(2,sh.getHomeworkId());
            statement.setString(3,sh.getHomeworkTitle());
            statement.setString(4,sh.getHomeworkContent());
            statement.setString(5,sh.getCreateTime());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<StudentHomework> selectAll(){
        List<StudentHomework> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sql="SELECT * FROM student_homework";
        Connection connection =  DriverManager.getConnection(allUrl);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getInt("id"));
                        sh.setStudentId(resultSet.getInt("student_id"));
                        sh.setHomeworkId(resultSet.getInt("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("title"));
                        sh.setHomeworkContent(resultSet.getString("content"));
                        sh.setCreateTime(resultSet.getString("create_time"));
                        list.add(sh);
                        System.out.println(sh.getId()+sh.getHomeworkTitle()+sh.getHomeworkContent()+sh.getCreateTime());
                    }
                } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Homework> findAll(){
        List<Homework> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sql="SELECT * FROM homework";
            Connection connection =  DriverManager.getConnection(allUrl);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // 获取执行结果
            while (resultSet.next()){
                Homework h = new Homework();
                h.setId(resultSet.getInt("id"));
                h.setTitle(resultSet.getString("title"));
                h.setContent(resultSet.getString("content"));
                h.setCreate_time(resultSet.getString("create_time"));
                list.add(h);
                System.out.println(h.getId()+h.getTitle()+h.getContent()+h.getCreate_time());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }


}
