package jdbc;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectPool {

    private static HikariDataSource hikariDataSource;

    public static HikariDataSource getHikariDataSource(){

        if(null != hikariDataSource){
            return hikariDataSource;
        }

        synchronized (ConnectPool.class) {
            if (null != hikariDataSource) {
                HikariConfig hikariConfig = new HikariConfig();
                String driverName = "com.mysql.cj.jdbc.Driver";
                hikariConfig.setUsername("root");
                hikariConfig.setPassword("123456");
                hikariConfig.setDriverClassName(driverName);
                hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC");
                hikariDataSource = new HikariDataSource(hikariConfig);
                return hikariDataSource;
            }
        }
        return null;
    }
}
