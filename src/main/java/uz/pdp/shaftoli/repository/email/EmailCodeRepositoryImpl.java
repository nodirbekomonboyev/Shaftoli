package uz.pdp.shaftoli.repository.email;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.EmailCodeEntity;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.repository.user.UserRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class EmailCodeRepositoryImpl implements EmailCodeRepository{
    @PersistenceContext
    private EntityManager entityManager;

    private final UserRepository userRepository;


    @Transactional
    @Override
    public void saveEmail(String email, String code) {
        EmailCodeEntity emailCodeEntity = new EmailCodeEntity(email, code,LocalDateTime.now().plus(2, ChronoUnit.MINUTES) );

        EmailCodeEntity emailCode;
        try {
             emailCode= findByEmail(email);
            if(emailCode != null){
                entityManager.createQuery(UPDATE_EMAIL_CODE)
                        .setParameter("email", email)
                        .setParameter("code", code)
                        .setParameter("limits", LocalDateTime.now().plus(2, ChronoUnit.MINUTES))
                        .executeUpdate();
            }
        } catch (IllegalArgumentException | NoResultException e){
            entityManager.persist(emailCodeEntity);
        }
    }

    @Transactional
    @Override
    public EmailCodeEntity findByEmail(String email) {
        return  entityManager.find(EmailCodeEntity.class, email);
    }


    @Transactional
    @Override
    public Boolean checkEmailAndCode(String userEmail, String code) {
        EmailCodeEntity singleResult = findByEmail(userEmail);

        String code1 = singleResult.getCode();

        if (Objects.equals(code1, code) && (singleResult.getLimits().equals(LocalDateTime.now()))){
            userRepository.changeValidated(userEmail);
            return true;
        }
        return false;
    }
}
