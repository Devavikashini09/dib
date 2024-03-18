package com.dib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "transactions")
public class Transaction {

    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    private String account_type;

    @NotNull
    private String name;

    @NotNull
    private String transaction_type;

    @NotNull
    private String transfer_type;

    @NotNull
    private Long amount;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;
    @PrePersist
    protected void onCreate(){
        this.created_at=LocalDateTime.now();
        this.updated_at=LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_at=LocalDateTime.now();
    }



}
