package uz.pdp.shaftoli.repository.user;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.model.UserEntity;

import java.util.ArrayList;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    @Override
    public UserEntity save(UserEntity user) {
        UserEntity user1 = checkUser(user.getEmail());
        if(user1 == null){
            jdbcTemplate.update(
                    INSERT_USER,
                    user.getId(),
                    user.getName(),
                    user.getRole(),
                    user.getEmail(),
                    user.getPassword());
            return null;
        } else if (user1.getValidated()) {
            return user1;
        }
        jdbcTemplate.update(
                UPDATE_USER_INFO,
                user.getEmail(),
                user.getName(),
                user.getPassword());
        return null;
    }

    @Override
    public ArrayList<UserEntity> getAll() {
        return (ArrayList<UserEntity>) jdbcTemplate.query(GET_ALL, new UserMapper());
    }

    @Override
    public UserEntity getById(UUID id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, new UserMapper(), id);
    }

    @Override
    public UserEntity checkUser(String email) {
        return jdbcTemplate.queryForObject(CHECK_USER, new UserMapper(), email);
    }

    @Override
    public UserEntity getByEmail(String email){
        return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, new UserMapper(), email);
    }

    @Override
    public Boolean checkUserValidate(String email) {
        return jdbcTemplate.queryForObject(CHANGE_VALIDATED, new UserMapper(), email).getValidated();

    }

    @Override
    public void changeValidated(String email) {
        jdbcTemplate.update(
                CHANGE_VALIDATED,
                email);
    }
}
