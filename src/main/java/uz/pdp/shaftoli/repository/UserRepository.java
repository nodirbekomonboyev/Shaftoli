package uz.pdp.shaftoli.repository;

import uz.pdp.shaftoli.entity.UserEntity;

public interface UserRepository {

    String GET_BY_EMAIL = "select * from users where email = ?;";
    void save(UserEntity user);
    UserEntity getByEmail(String email);
}
