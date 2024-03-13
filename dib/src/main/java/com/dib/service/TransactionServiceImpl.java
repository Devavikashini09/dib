package com.dib.service;

import com.dib.exception.NotFound;
import com.dib.model.Transaction;
import com.dib.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    public TransactionRepository transactionRepository;
    @Override
    public Transaction SaveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction) ;
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(int id) {
       return transactionRepository.findById(id);
    }

    @Override
    public Transaction updateTransactionById(int id, Transaction transaction) {
        if(transactionRepository.existsById(id)){
            transaction.setId(id);
            return transactionRepository.save(transaction);
        }
        else{
            throw new RuntimeException ("Transaction not found with"+ id);
        }
    }

    @Override
    public String deleteTransactionById(int id) {
        transactionRepository.deleteById(id);
        return "deleted successfully";
    }

}
