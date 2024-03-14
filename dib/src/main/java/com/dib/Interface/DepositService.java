package com.dib.Interface;

import com.dib.model.Customer;
import com.dib.model.Deposit;

import java.util.List;
import java.util.Optional;

public interface DepositService {
    public Deposit saveDeposit(Deposit deposit);
    public List<Deposit> getAllDeposit();
    public Optional<Deposit> getDepositById(int id);
    public Deposit updateDepositById(int id, Deposit deposit);
    public void deleteDepositById(int id);

}
