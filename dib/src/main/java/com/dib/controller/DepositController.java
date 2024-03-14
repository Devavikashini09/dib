package com.dib.controller;

import com.dib.model.Deposit;
import com.dib.Interface.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deposits")
public class DepositController {

    @Autowired
    public DepositService depositService;
    @PostMapping
    public Deposit saveDeposit(@RequestBody Deposit deposit){
        return depositService.saveDeposit(deposit);
    }
    @GetMapping
    public List<Deposit> getDeposits(){
        return depositService.getAllDeposit();
    }

    @GetMapping("{id}")
    public ResponseEntity<Deposit> getDepositById(@PathVariable int id){
        Optional<Deposit> deposit=depositService.getDepositById(id);
        return deposit.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Deposit> updateDepositById(@PathVariable int id,@RequestBody Deposit deposit){
        return ResponseEntity.ok(depositService.updateDepositById(id,deposit));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Deposit> DeleteDepositById(@PathVariable int id){
       depositService.deleteDepositById(id);
        return ResponseEntity.noContent().build();
    }

}
