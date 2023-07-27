package uz.pdp.shaftoli.service.user;

import uz.pdp.shaftoli.model.User;
import uz.pdp.shaftoli.service.BaseService;


public interface UserService extends BaseService<User> {

    void signUp(User user);

}
