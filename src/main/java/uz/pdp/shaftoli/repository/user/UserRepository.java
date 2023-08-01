package uz.pdp.shaftoli.repository.user;

import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.repository.BaseRepository;

public interface UserRepository extends BaseRepository<UserEntity> {

    String GET_BY_EMAIL = "select u from users u where u.email = :email";
    String UPDATE_USERS = "update users set name = :name, password = :password where email = :email";
      String GET_ALL = "select u from users u";

    Boolean checkValidated(String email);

    UserEntity signIn(String email, String password);



}
