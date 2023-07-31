package uz.pdp.shaftoli.repository.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.shaftoli.entity.UserEntity;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public UserEntity save(UserEntity user) {
        UserEntity user1 = null;
        try {
            user1 = findByEmail(user.getEmail());
        } catch (IllegalArgumentException | NoResultException e){
            entityManager.persist(user);
        }
        if( user1 != null && user1.getValidated()){
            return user1;
        }
        entityManager.createQuery(UPDATE_USERS)
                .setParameter("name", user.getName())
                .setParameter("password", user.getPassword())
                .setParameter("email", user.getEmail())
                .executeUpdate();
        return null;
    }

    @Transactional
    @Override
    public UserEntity findByEmail(String email) {
         return entityManager.createQuery(GET_BY_EMAIL, UserEntity.class)
                 .setParameter("email", email)
                 .getSingleResult();
    }

    @Override
    public List<UserEntity> getAll() {
        return entityManager.createQuery(GET_ALL, UserEntity.class)
                .getResultList();
    }


    @Override
    public Boolean checkValidated(String email) {
        UserEntity singleResult = entityManager.createQuery(GET_BY_EMAIL, UserEntity.class)
                .setParameter("email", email)
                .getSingleResult();
        System.out.println(singleResult.getValidated());
        return singleResult.getValidated();
    }

    @Override
    public UserEntity signIn(String email, String password) {
        UserEntity singleResult = entityManager.createQuery(GET_BY_EMAIL, UserEntity.class)
                .setParameter("email", email)
                .getSingleResult();

        if (singleResult.getPassword().equals(password) && singleResult.getValidated()){
            return singleResult;
        }
        return null;
    }

}
