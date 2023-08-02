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
    public TransactionEntity save(TransactionEntity trans) {
        return null;
    }

    @Override
    public String saveTransaction(TransactionEntity trans) {
        CardEntity senderCard = getCardById(String.valueOf(trans.getSenderId()));
        CardEntity receiverCard;
        try{
            receiverCard = getCardById(String.valueOf(trans.getReceiverId()));
        }
        catch (NoResultException e){
            return "Card not found";
        }
        if (senderCard.getBalance() < trans.getAmount() + trans.getAmount() * 0.01){
            return "Sorry! don't have enough money";
        }
        senderCard.setBalance(senderCard.getBalance() - trans.getAmount() - trans.getAmount() * 0.01);
        receiverCard.setBalance(receiverCard.getBalance() + trans.getAmount());
        updateCard(senderCard);
        updateCard(receiverCard);


        TransactionEntity transactionEntity = TransactionEntity.builder()
                .senderId(UUID.fromString(String.valueOf(trans.getSenderId())))
                .receiverId(UUID.fromString(String.valueOf(trans.getReceiverId())))
                .amount(trans.getAmount())
                .percentage(trans.getAmount() * 0.01)
                .build();
        //jgfyhtfytfyf
        //this is comment
        entityManager.persist(transactionEntity);
        return "Successful!!!";
    }

    public List<TransactionEntity> getByOwnerId (UUID id){
        return entityManager.createQuery("select c from card c where c.owner = :id", TransactionEntity.class)
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
