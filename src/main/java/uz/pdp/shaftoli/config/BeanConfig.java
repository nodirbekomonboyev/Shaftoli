package uz.pdp.shaftoli.config;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class BeanConfig {
    public static Connection connection;

    public Connection getConnection() {
        if(connection==null){
            try {
                Class.forName("org.postgresql.Driver");
                connection=  DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/shaftoli",
                        "postgres",
                        "2311"
                );
                //return connection;
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

}
