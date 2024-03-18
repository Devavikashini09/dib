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

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String account_type;

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
    private Long customer_id;

    @NotNull
    private  String gender;

    @NotNull
    private Long initial_balance;

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
