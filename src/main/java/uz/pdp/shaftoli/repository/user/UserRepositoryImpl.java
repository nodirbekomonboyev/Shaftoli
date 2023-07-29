package uz.pdp.shaftoli.repository.user;


import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.entity.UserEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    private final SessionFactory sessionFactory;
    private final Connection connection;

    @Override
    public UserEntity save(UserEntity user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
        return user;

    }

    @Override
    public ArrayList<UserEntity> getAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<UserEntity> dataList = session.createQuery(GET_ALL).getResultList();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return (ArrayList<UserEntity>) dataList;
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
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            UserEntity user = session.createQuery(CHECK_USER, UserEntity.class)
                    .setParameter(1,email)
                    .getSingleResult();
            transaction.commit();
            return user;
        }
    }

    @Override
    public UserEntity getByEmail(String email){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            UserEntity user =
                    session.createQuery(GET_USER_BY_EMAIL, UserEntity.class)
                            .setParameter(1,email)
                            .getSingleResult();
            transaction.commit();
            return user;
        }
    }

    @Override
    public String checkUserValidate(String email) {
        try(Session session  = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            String result = String.valueOf(session.createQuery(CHECK_VALIDATED, String.class)
                            .setParameter(1,email)
                            .getSingleResult());
            transaction.commit();
            return result;
        }

    }

    @Override
    public void changeValidated(String email) {
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_VALIDATED);
            preparedStatement.setString(1, email);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
