package com.dib.service;

import com.dib.Interface.AccountService;
import com.dib.model.Account;
import com.dib.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    public AccountRepository accountRepository;
    @Override
    public Account createAcocount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account updateAccountById(int id, Account account) {
        if(accountRepository.existsById(id)){
            account.setId(id);
            return accountRepository.save(account);
        }
        else{
            throw new RuntimeException("Account not found with"+ id);
        }
    }

    @Override
    public void deleteAccountById(int id) {
        accountRepository.deleteById(id);

    }
}
