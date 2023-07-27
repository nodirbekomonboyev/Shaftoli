package uz.pdp.shaftoli.service.user;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import uz.pdp.shaftoli.model.User;
import java.util.ArrayList;


@Service
public class UserServiceImpl implements UserService{
    @Override
    public User add(User user) {
        return user;
    }

    @Override
    public ArrayList<User> getAll() {

        return null;
    }

    @Override
    public User getById() {
        return null;
    }

    @Override
    public void signUp(User user) {

    }
}
