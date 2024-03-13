package com.dib.service;

import com.dib.model.Withdrawal;
import com.dib.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WithdrawalServiceImpl implements WithdrawalService{
    @Autowired
    public WithdrawalRepository withdrawalRepository;
    @Override
    public Withdrawal saveWithdrawal(Withdrawal withdrawal) {
        return withdrawalRepository.save(withdrawal) ;
    }

    @Override
    public List<Withdrawal> getAllWithdrawals() {
        return withdrawalRepository.findAll();
    }

    @Override
    public Optional<Withdrawal> getWithdrawalById(int id) {
        return withdrawalRepository.findById(id);
    }

    @Override
    public Withdrawal updateWithdrawalById(int id, Withdrawal withdrawal) {
       if(withdrawalRepository.existsById(id)){
           withdrawal.setId(id);
           return withdrawalRepository.save(withdrawal);
       }
       else {
           throw new RuntimeException("Withdrawal doesn't exits with"+id);
       }
    }

    @Override
    public void deleteWithdrawalById(int id) {
        withdrawalRepository.deleteById(id);
    }
}
