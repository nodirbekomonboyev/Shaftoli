package uz.pdp.shaftoli.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.shaftoli.entity.UserEntity;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{



    @Override
    public UserEntity add(UserEntity user) {
      //  userRepository.save(user);
        return user;
    }

    @Override
    public ArrayList<UserEntity> getAll() {

        return null;
    }

    @Override
    public UserEntity getById() {
        return null;
    }

    @Override
    public void userValidation(String email) {
       // userRepository.changeValidated(email);
    }

}
