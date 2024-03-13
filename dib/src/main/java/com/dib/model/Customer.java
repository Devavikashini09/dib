package com.dib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")

public class Customer {

    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private AccountType accounttype;

    @NotNull
    private String first_name;

    @NotNull
    private String last_name;

    private Long mobile_no;

    @NotEmpty
    private String address;

    private String city;

    private String state;

    private String country;

    @NotEmpty @Column(unique = true)
    private String email;

    private Date date_of_birth;

    private Long customer_id;

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
