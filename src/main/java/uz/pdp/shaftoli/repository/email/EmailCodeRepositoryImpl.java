package uz.pdp.shaftoli.repository.email;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.EmailCodeEntity;
import uz.pdp.shaftoli.repository.user.UserRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Repository
public class EmailCodeRepositoryImpl implements EmailCodeRepository{
    @PersistenceContext
    private EntityManager entityManager;
    private UserRepository userRepository;


    @Transactional
    @Override
    public void saveEmail(String email, String code) {
        EmailCodeEntity emailCode = new EmailCodeEntity(email, code,LocalDateTime.now().plus(2, ChronoUnit.MINUTES) );
        entityManager.persist(emailCode);

    }


    @Override
    public Boolean checkEmailAndCode(String userEmail, String code) {
        EmailCodeEntity singleResult = entityManager.createQuery(GET_BY_EMAIL_CODE, EmailCodeEntity.class)
                .setParameter("email", userEmail)
                .getSingleResult();

        String code1 = singleResult.getCode();

        if (Objects.equals(code1, code)){
            userRepository.changeValidated(userEmail);
            return true;
        }
        return false;
    }
}
