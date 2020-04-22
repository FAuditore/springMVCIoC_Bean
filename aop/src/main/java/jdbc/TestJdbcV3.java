package jdbc;

import java.sql.*;

/**
 * TestJdbc
 *
 * @author wangkm
 * @date 2020-02-27
 * @since 0.0.1
 */
public class TestJdbcV3 {

    public static String getMysql(){

        String url = "jdbc:mysql://127.0.0.1:3306/school";

        String allUrl = url + "?user=root&password=123456";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_student_homework";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int n = 100;

        while (n-- >= 0){
            try(Connection connection =  DriverManager.getConnection(allUrl)) {
                try(Statement statement = connection.createStatement()){
                    try(ResultSet resultSet = statement.executeQuery(sqlString)){
                        // 获取执行结果
                        while (resultSet.next()){
                            System.out.println(resultSet.getString(4));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        getMysql();
    }

}
