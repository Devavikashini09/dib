package com.dib.service;

import com.dib.model.Account;
import com.dib.model.Customer;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public Account createAccount(Account account);
    public List<Account> getAllAccount();

    public Optional<Account> getAccountById(int id);

    public Account updateAccountById(int id,Account account);

    public void deleteAccountById(int id);

}
