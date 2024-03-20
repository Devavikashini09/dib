package com.dib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "branches")
public class Branch {

    @Id @GeneratedValue
    private int id;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Customer> accounts;

    private String name;

    private String address;

    private String city;

    private String state;

    private String country;

}
