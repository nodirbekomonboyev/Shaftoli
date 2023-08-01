package uz.pdp.shaftoli.repository.email;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.EmailCodeEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Repository
public class EmailCodeRepositoryImpl implements EmailCodeRepository{
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void saveEmail(String email, String code) {
        entityManager.createQuery(UPDATE_EMAIL_CODE)
                .setParameter("email", email)
                .setParameter("code", code)
                .setParameter("limit", LocalDateTime.now().plus(1, ChronoUnit.MINUTES))
                .setParameter("email", email)
                .executeUpdate();
    }


    @Override
    public Boolean checkEmailAndCode(String userEmail, String code) {
        EmailCodeEntity singleResult = entityManager.createQuery(GET_BY_EMAIL_CODE, EmailCodeEntity.class)
                .setParameter(1, userEmail)
                .getSingleResult();

        String code1 = singleResult.getCode();
        return Objects.equals(code1, code);

    }
}
