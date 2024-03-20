package com.dib.Interface;

import com.dib.model.Account;
import com.dib.model.Transaction;


import java.util.List;
import java.util.Optional;

public interface TransactionService {
    void performTransaction(int id, Account account, Long account_num1, Long account_num2, String transaction_type, Long amount);
    public Transaction SaveTransaction(Transaction transaction);
    public List<Transaction> getAllTransaction();
    public Optional<Transaction> getTransactionById(int id);
    public Transaction updateTransactionById(int id, Transaction transaction);
    public String deleteTransactionById(int id);
}
