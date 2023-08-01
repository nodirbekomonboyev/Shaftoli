package uz.pdp.shaftoli.repository.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.EmailCodeEntity;
import uz.pdp.shaftoli.entity.UserEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public UserEntity save(UserEntity userEntity){
        UserEntity user = null;
        try {
            user = findByEmail(userEntity.getEmail());
        } catch (IllegalArgumentException | NoResultException e){
            entityManager.persist(userEntity);
        }
        if (user != null && user.getValidated()){
            return user;
        }
        entityManager.createQuery(UPDATE_USERS)
                .setParameter("name", userEntity.getName())
                .setParameter("password", userEntity.getPassword())
                .setParameter("email", userEntity.getEmail())
                .executeUpdate();
        return null;
    }

    @Transactional
    @Override
    public UserEntity findByEmail(String email){
        return entityManager.createQuery(GET_BY_EMAIL, UserEntity.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<UserEntity> getAll() {
        return entityManager.createQuery(GET_ALL, UserEntity.class)
                .getResultList();
    }


    @Transactional
    @Override
    public Boolean checkValidated(String email) {
        return findByEmail(email).getValidated();
    }

    @Transactional
    @Override
    public UserEntity signIn(String email, String password) {
        UserEntity singleResult = findByEmail(email);
        if (singleResult.getPassword().equals(password) && singleResult.getValidated()){
            return singleResult;
        }
        return null;
    }






}
