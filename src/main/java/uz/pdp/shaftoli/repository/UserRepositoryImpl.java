package uz.pdp.shaftoli.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.UserEntity;

@Repository
public class UserRepositoryImpl implements UserRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(UserEntity user) {
        entityManager.persist(user);
    }

    @Override
    public UserEntity getByEmail(String email) {
         return entityManager.createQuery(GET_BY_EMAIL, UserEntity.class)
                 .setParameter(1, email)
                 .getSingleResult();
    }
}
