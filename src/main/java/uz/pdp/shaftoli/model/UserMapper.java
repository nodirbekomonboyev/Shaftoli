package uz.pdp.shaftoli.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = User.builder()
                .name(rs.getString("name"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .role(UserRole.valueOf(rs.getString("userRole")))
                .build();
        user.setId(UUID.fromString(rs.getString("id")));
        user.setCreatedDate(Timestamp.valueOf(rs.getTimestamp("created_date").toLocalDateTime()));
        user.setUpdatedDate(Timestamp.valueOf(rs.getTimestamp("updated_date").toLocalDateTime()));
        return user;
    }
}
