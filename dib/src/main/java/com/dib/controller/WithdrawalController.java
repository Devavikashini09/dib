package com.dib.controller;

import com.dib.model.Withdrawal;
import com.dib.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/withdrawals")
public class WithdrawalController {
    @Autowired
    public WithdrawalService withdrawalService;
    @PostMapping
    public ResponseEntity<Withdrawal> createWithdrawal(@RequestBody Withdrawal withdrawal) {
        Withdrawal createdWithdrawal = withdrawalService.saveWithdrawal(withdrawal);
        return new ResponseEntity<>(createdWithdrawal, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Withdrawal> getAllWithdrawals(){
        return withdrawalService.getAllWithdrawals();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Withdrawal> getWithdrawalById(@PathVariable int id,@RequestBody Withdrawal withdrawal){
        Optional <Withdrawal> withdrawal1=withdrawalService.getWithdrawalById(id);
        return withdrawal1.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Withdrawal> updateWithdrawalById(@PathVariable int id, @RequestBody Withdrawal withdrawal){
        return ResponseEntity.ok(withdrawalService.updateWithdrawalById( id,withdrawal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWithdrawalById(@PathVariable int id) {
        String message;
        try {
            withdrawalService.deleteWithdrawalById(id);
            message = "Withdrawal with ID " + id + " deleted successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Failed to delete withdrawal with ID " + id + ": " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }
    }


}
