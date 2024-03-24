package com.dib.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "customers")

public class Customer {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String first_name;

    @NotNull
    private String last_name;

    @NotNull @Column(unique = true,length = 11)
    private Long mobile_no;

    @NotEmpty
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String country;

    @NotEmpty
    @Column(unique = true)
    private String email;

    private Date date_of_birth;

    @NotNull
    private  String gender;

    @NotNull
    private BigDecimal account_balance;

    private String account_number;

    @NotNull
    private String  customer_id;

    private String status;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Account> accounts;
//
//    @ManyToOne
//    @JoinColumn(name = "branch_id")
//    private Branch Branch;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @NotNull
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
