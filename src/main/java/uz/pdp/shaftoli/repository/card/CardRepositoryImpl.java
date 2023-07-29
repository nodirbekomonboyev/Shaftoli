package uz.pdp.shaftoli.repository.card;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.entity.CardEntity;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository{

        private final SessionFactory sessionFactory;
        private final Connection connection;

        @Override
        public CardEntity save(CardEntity card) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(card);
            transaction.commit();
            session.close();
            return card;
        }

        @Override
        public CardEntity getById(UUID id) {
            try(Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                CardEntity card = session.get(CardEntity.class, id);
                transaction.commit();
                return card;
            }
        }

        @Override
        public ArrayList<CardEntity> getAll() {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            List<CardEntity> dataList = session.createQuery(GET_ALL).getResultList();
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            return (ArrayList<CardEntity>) dataList;
        }
}
