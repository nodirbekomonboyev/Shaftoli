package uz.pdp.shaftoli.service.user;

import uz.pdp.shaftoli.model.UserEntity;
import uz.pdp.shaftoli.service.BaseService;


public interface UserService extends BaseService<UserEntity> {
    void userValidation(String email);

}
