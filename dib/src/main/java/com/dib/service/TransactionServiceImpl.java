package com.dib.service;

import com.dib.Interface.TransactionService;
import com.dib.model.Account;
import com.dib.model.Transaction;
import com.dib.repository.AccountRepository;
import com.dib.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    public TransactionRepository transactionRepository;

    @Autowired
    public AccountRepository accountRepository;


    @Override
    public void performTransaction(int id, Account account, Long account_num1, Long account_num2, String transaction_type, Long amount) {

    }

    @Override
    public Transaction SaveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
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
        if (transactionRepository.existsById(id)) {
            transaction.setId(id);
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction not found with id: " + id);
        }
    }

    @Override
    public String deleteTransactionById(int id) {
        transactionRepository.deleteById(id);
        return "Transaction with id: " + id + " deleted successfully";
    }
}
