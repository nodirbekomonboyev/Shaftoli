package uz.pdp.shaftoli.repository;

import uz.pdp.shaftoli.entity.UserEntity;

public interface UserRepository {

    String GET_BY_EMAIL = "select u from users u where u.email = :email";
    String UPDATE_USERS = "update users set name = :name, password = :password where email = :email";
    UserEntity save(UserEntity user);
    UserEntity findByEmail(String email);
}
