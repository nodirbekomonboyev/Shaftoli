package uz.pdp.shaftoli.repository.card;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.UserEntity;

import java.util.List;





@Repository
public class CardRepositoryImpl implements CardRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public CardEntity save(CardEntity cardEntity) {





        CardEntity card = null;
        try{
        card = getCardByNumbers(cardEntity.getCardNumber());
        }catch(IllegalArgumentException | NoResultException e){
            entityManager.persist(cardEntity);
            return cardEntity;
        }
        return null;
    }

    @Override
    public CardEntity findByEmail(String email) {
        return null;
    }

    @Override
    public List<CardEntity> getAll() {
        return null;
    }

    @Override
    public List<CardEntity> getUsersCards(UserEntity owner) {
        return entityManager.createQuery("select c from card c where owner = :owner", CardEntity.class)
                .setParameter("owner", owner)
                .getResultList();
    }

    @Override
    public CardEntity getCardByNumbers(String numbers) {
        return entityManager.find(CardEntity.class, numbers);
    }


}
