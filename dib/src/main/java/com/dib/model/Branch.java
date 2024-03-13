package com.dib.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "branches")
public class Branch {

    @Id @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    private String city;

    private String state;

    private String country;

}
