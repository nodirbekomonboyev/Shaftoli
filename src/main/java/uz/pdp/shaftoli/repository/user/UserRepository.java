package uz.pdp.shaftoli.repository.user;

import uz.pdp.shaftoli.model.UserEntity;
import uz.pdp.shaftoli.repository.BaseRepository;

public interface UserRepository extends BaseRepository<UserEntity> {
    String INSERT_USER = "insert into users(id, name, role, email, password) " +
            "values(?, ?, ?, ?, ?);";
    String GET_USER_BY_ID = "select * from users where id = ?;";
    String GET_USER_BY_EMAIL = "select * from users u where email = ?;";
    String GET_ALL = "select * from users;";
    String CHANGE_VALIDATED = "update users u set validated = true where u.email = ?;";
    String CHECK_VALIDATED = "select u.validated from users u where u.email = ?";
    String CHECK_USER = "select * from users u where u.email = ?;";
    String UPDATE_USER_INFO = "select * from update_user_info(?,?,?);";

    UserEntity checkUser(String email);
    UserEntity getByEmail(String email);
    Boolean checkUserValidate(String email);
    void changeValidated(String email);

}
