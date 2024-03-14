package com.dib.controller;

import com.dib.model.Transaction;
import com.dib.Interface.TransactionService;
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
    public ResponseEntity<String> deleteTransactionById(@PathVariable int id) {
        String message;
        try {
            transactionService.deleteTransactionById(id);
            message = "Transaction with ID " + id + " deleted successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Failed to delete transaction with ID " + id + ": " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }
    }


}
