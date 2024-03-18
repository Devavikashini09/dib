package com.dib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "permissions")

public class Permission {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

}
