package com.dib.service;

import com.dib.model.Deposit;
import com.dib.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepositServiceImpl implements DepositService{
    @Autowired
    public DepositRepository depositRepository;
    @Override
    public Deposit saveDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Override
    public List<Deposit> getAllDeposit() {
        return depositRepository.findAll();
    }

    @Override
    public Optional<Deposit> getDepositById(int id) {
        return depositRepository.findById(id);
    }

    @Override
    public Deposit updateDepositById(int id, Deposit deposit) {
        if(depositRepository.existsById(id)){
            deposit.setId(id);
            return depositRepository.save(deposit);
        }
        else{
            throw new RuntimeException("Deposit not found with"+ id);
        }
    }

    @Override
    public void deleteDepositById(int id) {
         depositRepository.deleteById(id);
    }
}
