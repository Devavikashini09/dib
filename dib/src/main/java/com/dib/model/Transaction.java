package com.dib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "transactions")
public class Transaction {

    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @NotNull
    private String name;

    @NotNull
    private String transactionType;

    @NotNull
    private Long amount;

    @NotNull
    private String transactionStatus;

}
