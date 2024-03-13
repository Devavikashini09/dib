package com.dib.service;

import com.dib.model.Transaction;


import java.util.List;
import java.util.Optional;

public interface TransactionService {
    public Transaction SaveTransaction(Transaction transaction);
    public List<Transaction> getAllTransaction();
    public Optional<Transaction> getTransactionById(int id);
    public Transaction updateTransactionById(int id, Transaction transaction);
    public String deleteTransactionById(int id);
}
