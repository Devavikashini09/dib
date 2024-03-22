package com.dib.Interface;

import com.dib.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public Account createAccount(Account account);
    public List<Account> getAllAccount();

    public Optional<Account> getAccountById(int id);

    public Account updateAccountById(int id,Account account);

    public String deleteAccountById(int id);

}
