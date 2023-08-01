package uz.pdp.shaftoli.repository.email;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.EmailCodeEntity;
import uz.pdp.shaftoli.entity.UserEntity;
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
        EmailCodeEntity emailCodeEntity = new EmailCodeEntity(email, code,LocalDateTime.now().plus(2, ChronoUnit.MINUTES) );

        EmailCodeEntity emailCode = null;
        try {
            emailCode = findByEmail(email);
        } catch (IllegalArgumentException | NoResultException e){
            entityManager.persist(emailCodeEntity);
        }
        entityManager.createQuery(UPDATE_EMAIL_CODE)
                .setParameter("email", email)
                .setParameter("code", code)
                .setParameter("limits", LocalDateTime.now().plus(2, ChronoUnit.MINUTES))
                .executeUpdate();

    }

    private EmailCodeEntity findByEmail(String email) {
        return  entityManager.createQuery(FIND_BY_EMAIL, EmailCodeEntity.class)
                .setParameter("email", email)
                .getSingleResult();
    }


    @Override
    public Boolean checkEmailAndCode(String userEmail, String code) {
        EmailCodeEntity singleResult = findByEmail(userEmail);

        String code1 = singleResult.getCode();

        if (Objects.equals(code1, code) && (singleResult.getLimits().isBefore(LocalDateTime.now()))){
            userRepository.changeValidated(userEmail);
            return true;
        }
        return false;
    }
}
