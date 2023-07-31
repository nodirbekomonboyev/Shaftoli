package uz.pdp.shaftoli.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.repository.user.UserRepository;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    public UserEntity add(UserEntity user) {
        return userRepository.save(user);
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
