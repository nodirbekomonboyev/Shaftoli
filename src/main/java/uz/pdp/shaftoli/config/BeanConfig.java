package uz.pdp.shaftoli.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class BeanConfig {
   @Bean
    public DataSource dataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("org.postgresql.Driver");
       dataSource.setUrl("jdbc:postgresql://localhost:5432/shaftoli");
       dataSource.setUsername("postgres");
       dataSource.setPassword("123");
       return dataSource;
   }

   @Bean
   public JdbcTemplate jdbcTemplate(DataSource dataSource) {
      return new JdbcTemplate(dataSource);
   }
}
