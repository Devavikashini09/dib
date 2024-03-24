package com.dib.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "accounts")

public class Account {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(unique = true,length = 11)
    private Long account_number;

    @NotNull
    private String account_type;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "branch_id",nullable = false)
//    private Branch branch;
//
//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
//    private List<Transaction> transactions = new ArrayList<>();

    @NotNull
    private Long balance;

    private Date opening_date;

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

    public Object getAccountNumber() {
        return this.account_number;
    }
}
