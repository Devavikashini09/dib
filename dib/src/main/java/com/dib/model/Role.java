package com.dib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")

public class Role {
    @Id @GeneratedValue
    private int id;

    @NotNull @Column(unique = true)
    private String  name;
}
