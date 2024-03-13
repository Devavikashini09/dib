package com.dib.controller;

import com.dib.model.Account;
import com.dib.model.Branch;
import com.dib.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  @Autowired
    public AccountService accountService;
  @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @NonNull Account account){
      return new ResponseEntity<>(accountService.createAccount(account),HttpStatus.CREATED);
  }
  @GetMapping
    public List<Account> getAllAccount(){
      return accountService.getAllAccount();
  }
  @GetMapping("/{id}")
  public ResponseEntity<Account> getAccountById(@PathVariable int id){
    Optional<Account> account=accountService.getAccountById(id);
    return account.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Account> updateAccountById(@PathVariable int id,@RequestBody Account account){
     return ResponseEntity.ok(accountService.updateAccountById( id,account));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteAccountById(@PathVariable int id) {
    String message;
    try {
      accountService.deleteAccountById(id);
      message = "Account with ID " + id + " deleted successfully.";
      return ResponseEntity.status(HttpStatus.OK).body(message);
    } catch (Exception e) {
      message = "Failed to delete account with ID " + id + ": " + e.getMessage();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
  }



}
