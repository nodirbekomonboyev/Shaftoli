package uz.pdp.shaftoli.repository.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.model.Card;
import uz.pdp.shaftoli.model.CardMapper;
import uz.pdp.shaftoli.model.TransMapper;
import uz.pdp.shaftoli.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public Transaction save(Transaction transaction) {
        jdbcTemplate.update(
                INSERT_TRANSACTION,
                transaction.getId(),
                transaction.getSenderId(),
                transaction.getAmount(),
                transaction.getPercentage());
        return transaction;
    }

    @Override
    public ArrayList<Transaction> getAll() {
        return (ArrayList<Transaction>) jdbcTemplate.query(GET_ALL, new TransMapper());
    }

    @Override
    public Transaction getById(UUID id) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransaction(UUID id) {
        return jdbcTemplate.query(GET_ALL_TRANSACTION, new TransMapper(), id);
    }
}
