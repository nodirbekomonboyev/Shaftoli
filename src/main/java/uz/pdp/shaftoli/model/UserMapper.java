package uz.pdp.shaftoli.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = User.builder()
                .name(rs.getString("name"))
                .role(UserRole.valueOf(rs.getString("role")))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .validated(Boolean.FALSE)
                .build();
        user.setId(UUID.fromString(rs.getString("id")));
        user.setCreatedDate(rs.getTimestamp("created_date"));
        user.setUpdatedDate(rs.getTimestamp("updated_date"));
        return user;
    }
}
