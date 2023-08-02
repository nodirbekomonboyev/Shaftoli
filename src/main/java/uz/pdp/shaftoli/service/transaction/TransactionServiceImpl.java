package uz.pdp.shaftoli.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.shaftoli.entity.TransactionEntity;
import uz.pdp.shaftoli.repository.transaction.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    @Override
    public TransactionEntity add(TransactionEntity transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public  List<TransactionEntity> getAll() {
        return  transactionRepository.getAll();

    }

    @Override
    public TransactionEntity getById() {
        return null;
    }
}
