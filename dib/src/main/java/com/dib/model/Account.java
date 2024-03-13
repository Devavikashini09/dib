package com.dib.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "accounts")

public class Account {

    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(unique = true,length = 11)
    private Long accountNumber;

    @NotNull
    private String accountType;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @NotNull
    private Long balance;

    private Date openingDate;

    private Date closingDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt=LocalDateTime.now();
    }

}
