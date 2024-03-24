package com.dib.model;

import jakarta.persistence.*;
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

//    @OneToMany(mappedBy = "Branch")
//    private List<Customer> customers;

    private String name;

    private String address;

    private String city;

    private String state;

    private String country;

}
