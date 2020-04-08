package jdbc;

import java.io.PrintWriter;
import java.sql.*;

/**
 * TestJdbc
 *
 * @author wangkm
 * @date 2020-02-27
 * @since 0.0.1
 */
public class TestJdbc {

    public static String getMysql(){

        String url = "jdbc:mysql://127.0.0.1:3306/school";

        String allUrl = url + "?user=root&password=123456";

//        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM student";

//         把DriverManager println输出到控制台
//        DriverManager.setLogWriter(new PrintWriter(System.out));

        try {
            // 加载驱动
//            Class.forName(driverName);

            // 创建连接
            Connection connection =  DriverManager.getConnection(allUrl);

            // 通过连接获取statement
            Statement statement = connection.createStatement();

            // statement 做一些 增删改查
            ResultSet resultSet = statement.executeQuery(sqlString);

            // 获取执行结果
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        getMysql();
    }

}
