package uz.pdp.shaftoli.repository.user;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.entity.UserEntity;

import java.util.ArrayList;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private final SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public UserEntity save(UserEntity user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public ArrayList<UserEntity> getAll() {
        return null;
        /*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<UserEntity> dataList = session.createQuery(GET_ALL).getResultList();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return (ArrayList<UserEntity>) dataList;*/
    }

    @Override
    public UserEntity getById(UUID id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            UserEntity user = session.get(UserEntity.class, id);
            transaction.commit();
            return user;
        }
    }

    @Override
    public UserEntity checkUser(String email) {
        return null;
    }

    @Override
    public UserEntity getByEmail(String email){
       return null;
        // return entityManager
       //         .createQuery("select u from users u where email = :email", UserEntity.class)
       //         .setParameter("username", email)
       //         .getSingleResult();
    }

    @Override
    public String checkUserValidate(String email) {
        return null;

    }

    @Override
    public void changeValidated(String email) {
        // there is code logic
    }
}
