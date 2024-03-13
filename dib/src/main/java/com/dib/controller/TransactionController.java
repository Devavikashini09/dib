package com.dib.controller;

import com.dib.model.Transaction;
import com.dib.service.TransactionService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")

public class TransactionController {
    @Autowired
    public TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody @NonNull  Transaction transaction)
    {
        return new ResponseEntity<>(transactionService.SaveTransaction(transaction), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransaction();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable int id){
        Optional<Transaction> transaction=transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransactionById(@PathVariable int id,@RequestBody Transaction transaction){
       return new ResponseEntity<>(transactionService.updateTransactionById(id,transaction),HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionById(@PathVariable int id){
        transactionService.deleteTransactionById(id);
        return ResponseEntity.noContent().build();
    }

}
