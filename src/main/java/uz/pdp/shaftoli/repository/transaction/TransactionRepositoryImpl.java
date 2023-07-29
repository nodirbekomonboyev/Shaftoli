package uz.pdp.shaftoli.repository.transaction;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.entity.TransactionEntity;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {
    private final SessionFactory sessionFactory;
    private final Connection connection;
    @Override
    public TransactionEntity save(TransactionEntity transactionEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(transactionEntity);
        transaction.commit();
        session.close();
        return transactionEntity;
    }

    @Override
    public ArrayList<TransactionEntity> getAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<TransactionEntity> dataList = session.createQuery(GET_ALL).getResultList();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return (ArrayList<TransactionEntity>) dataList;
    }

    @Override
    public TransactionEntity getById(UUID id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            TransactionEntity transactionEntity = session.get(TransactionEntity.class, id);
            transaction.commit();
            return transactionEntity;
        }
    }

    @Override
    public List<TransactionEntity> getAllBetweenUsersTransaction(UUID id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<TransactionEntity> dataList = session.createQuery(GET_ALL_USER_TRANSACTION, TransactionEntity.class)
                .setParameter(1,id)
                .setParameter(2,id)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return dataList;
    }
}
