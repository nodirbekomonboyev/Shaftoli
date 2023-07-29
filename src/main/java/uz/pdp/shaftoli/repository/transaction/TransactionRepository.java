package uz.pdp.shaftoli.repository.transaction;

import uz.pdp.shaftoli.entity.TransactionEntity;
import uz.pdp.shaftoli.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends BaseRepository<TransactionEntity> {
    String INSERT_TRANSACTION = "insert into transaction(id, sender_id, receiver_id, amount, percentage) " +
            "values(?, ?, ?, ?, ?);";
    String GET_TRANSACTION_BY_ID = "select * from transaction where t.sender_id = ? or t.receiver_id = ?;";

    //String GET_CARD_BY_USERNAME = "select * from card where username = ?;";
    String GET_ALL = "select * from transaction;";
    String GET_ALL_USER_TRANSACTION = "select * from transaction t where t.sender_id = ? or t.reciever_id = ?;";

    List<TransactionEntity> getAllBetweenUsersTransaction(UUID id);
}
