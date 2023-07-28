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


    private final String insert_user = "insert into users(id,name,role,email,password)" +
            "values(?,?,?,?,?);";
    private final String get_by_id = "select * from users where id = ?;";
    @Override
    public void save(User user) {
        jdbcTemplate.update(
                insert_user,
                user.getId(),
                user.getName(),
                user.getRole(),
                user.getEmail(),
                user.getPassword()
        );

    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }

    @Override
    public User getById(UUID id) {
      return jdbcTemplate.queryForObject(get_by_id, User.class, id);
    }
}
