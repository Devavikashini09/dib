package com.dib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    private String first_name;

    private String last_name;

    @Column(unique = true)
    private String email;

    @NotNull
    private String position;

    private String address;

    @Column(unique = true,length = 10)
    private Long mobile_no;

    private Long employee_id;

    private String gender;

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
