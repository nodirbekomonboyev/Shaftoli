package uz.pdp.shaftoli.repository.transaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.TransactionEntity;
import uz.pdp.shaftoli.entity.UserEntity;

import java.util.List;
import java.util.UUID;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public TransactionEntity save(TransactionEntity transactionEntity) {
        return null;
    }
    public TransactionEntity saveTransaction(String senderId, String recieverId, Double amount){
        CardEntity senderCard = getCardById(senderId);
        CardEntity recieverCard = getCardById(recieverId);
        if (senderCard.getBalance() < amount + amount * 0.1){
            return null;
        }
        senderCard.setBalance(senderCard.getBalance() - amount - amount * 0.1);
        recieverCard.setBalance(recieverCard.getBalance() + amount);
        updateCard(senderCard);
        updateCard(recieverCard);


        TransactionEntity transactionEntity = TransactionEntity.builder()
                .senderId(UUID.fromString(senderId))
                .receiverId(UUID.fromString(recieverId))
                .amount(amount)
                .percentage(amount * 0.1)
                .build();

        entityManager.persist(transactionEntity);
        return transactionEntity;
    }

    public List<TransactionEntity> getByOwnerId (UUID id){
        return entityManager.createQuery("select c from card c where c.ownerId = :id", TransactionEntity.class)
                .setParameter("id", id)
                .getResultList();
    }



    @Override
    public TransactionEntity findByEmail(String email) {
        return null;
    }

    @Override
    public List<TransactionEntity> getAll() {
        return null;
    }

    public CardEntity getCardById(String id) {
        return entityManager.createQuery("select c from card c where c.id = :id", CardEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    public void updateCard(CardEntity card){
        entityManager.createQuery("update card set balance = :balance where id = :id", CardEntity.class)
                .setParameter("id", card.getId())
                .setParameter("balance", card.getBalance())
                .getSingleResult();
    }


}
