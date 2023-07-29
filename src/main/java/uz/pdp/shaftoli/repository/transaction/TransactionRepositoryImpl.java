package uz.pdp.shaftoli.repository.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.entity.TransactionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public TransactionEntity save(TransactionEntity transaction) {
        jdbcTemplate.update(
                INSERT_TRANSACTION,
                transaction.getId(),
                transaction.getSenderId(),
                transaction.getAmount(),
                transaction.getPercentage());
        return transaction;
    }

    @Override
    public ArrayList<TransactionEntity> getAll() {
        return (ArrayList<TransactionEntity>) jdbcTemplate.query(GET_ALL, new TransMapper());
    }

    @Override
    public TransactionEntity getById(UUID id) {
        return null;
    }

    @Override
    public List<TransactionEntity> getAllTransaction(UUID id) {
        return jdbcTemplate.query(GET_ALL_TRANSACTION, new TransMapper(), id);
    }
}
