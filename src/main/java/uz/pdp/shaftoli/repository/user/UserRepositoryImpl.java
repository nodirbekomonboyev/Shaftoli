package uz.pdp.shaftoli.repository.user;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.model.User;
import uz.pdp.shaftoli.model.UserMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    private final JdbcTemplate jdbcTemplate;
    @Override
    public User save(User user) {
        Boolean checkUser = checkUser(user.getEmail());
        if(checkUser){
            jdbcTemplate.update(
                    INSERT_USER,
                    user.getId(),
                    user.getName(),
                    user.getRole(),
                    user.getEmail(),
                    user.getPassword());
            return null;
        } else if (!checkUser){
            return user;
        }
        jdbcTemplate.update(
                UPDATE_USER_INFO,
                user.getEmail(),
                user.getName(),
                user.getPassword());
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return (ArrayList<User>) jdbcTemplate.query(GET_ALL, new UserMapper());
    }

    @Override
    public User getById(UUID id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, new UserMapper(), id);
    }

    @Override
    public Boolean checkUser(String email) {
        RowMapper<Boolean> checkUsers = new RowMapper<>() {
            @Override
            public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getBoolean("check_users");
            }
        };
        return jdbcTemplate.queryForObject(CHECK_USER, checkUsers, email);    }

    @Override
    public Boolean getByEmail(String email){
        RowMapper<Boolean> checkUsers = new RowMapper<>() {
            @Override
            public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getBoolean("check_users");
            }
        };
        return jdbcTemplate.queryForObject(CHECK_USER, checkUsers, email);
    }

    @Override
    public  Boolean checkUserValidate(String email) {
        return jdbcTemplate.queryForObject(CHECK_VALIDATED, new UserMapper(), email).getValidated();
    }

    @Override
    public void changeValidated(String email) {
        jdbcTemplate.update(
                CHANGE_VALIDATED,
                email);
    }
}
