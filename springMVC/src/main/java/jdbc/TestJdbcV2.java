package jdbc;

import java.sql.*;

/**
 * TestJdbc
 * 手动关闭创建的Mysql连接
 *
 * @author wangkm
 * @date 2020-02-27
 * @since 0.0.1
 */
public class TestJdbcV2 {

    public static String getMysql(){

        String url = "jdbc:mysql://127.0.0.1:3306/school";

        String allUrl = url + "?user=root&password=123456";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_student_homework";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        int n = 100;

        while(n-- >= 0) {
            try {
                // 加载驱动
                Class.forName(driverName);

                // 创建连接
                connection = DriverManager.getConnection(allUrl);

                // 通过连接获取statement
                statement = connection.createStatement();

                // statement 做一些 增删改查
                resultSet = statement.executeQuery(sqlString);

                // 获取执行结果
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(4));
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                if (null != resultSet) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != statement) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return null;
    }

    public static void main(String[] args) {
        getMysql();
    }

}
