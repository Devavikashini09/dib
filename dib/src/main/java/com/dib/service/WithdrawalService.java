package com.dib.service;

import com.dib.model.Withdrawal;

import java.util.List;
import java.util.Optional;

public interface WithdrawalService {
    public Withdrawal saveWithdrawal(Withdrawal withdrawal);
    public List<Withdrawal> getAllWithdrawals();
    public Optional<Withdrawal> getWithdrawalById(int id);
    public Withdrawal updateWithdrawalById(int id,Withdrawal withdrawal);
    public void deleteWithdrawalById(int id);
}
