package uz.pdp.shaftoli.repository.user;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.model.User;
import uz.pdp.shaftoli.model.UserMapper;

import java.util.ArrayList;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    private final JdbcTemplate jdbcTemplate;
    @Override
    public User save(User user) {
        jdbcTemplate.update(
                INSERT_USER,
                user.getId(),
                user.getName(),
                user.getRole(),
                user.getEmail(),
                user.getPassword());
        return user;
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
    public User getByEmail(String email){
        return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, new UserMapper(), email);
    }

    @Override
    public Boolean checkUserValidate(String email) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, new UserMapper(), email).getValidated();

    }

    @Override
    public void changeValidated(String email) {
        jdbcTemplate.update(
                CHANGE_VALIDATED,
                email);
    }


}
