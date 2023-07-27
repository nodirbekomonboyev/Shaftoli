package uz.pdp.shaftoli.service.user;

import uz.pdp.shaftoli.model.User;
import uz.pdp.shaftoli.service.BaseService;

import java.util.ArrayList;

public interface UserService extends BaseService<User> {
    User addUser(User user);
    ArrayList<User> getAll();
}
