package uz.pdp.shaftoli.repository.email;

import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.entity.EmailCodeEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Repository
public class EmailCodeRepositoryImpl implements EmailCodeRepository{
    @Override
    public void save(String email, String code) {
        EmailCodeEntity emailCode = new EmailCodeEntity(
                email,
                code,
                LocalDateTime.now().plus(5, ChronoUnit.MINUTES));
        // emailCode ni databasega saqlash kerak!!!!
    }

    @Override
    public String findCodeByEmail(String userEmail) {

        return userEmail;
    }
}
