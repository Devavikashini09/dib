package com.dib.repository;

import com.dib.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalRepository extends JpaRepository<Withdrawal,Integer> {
}
