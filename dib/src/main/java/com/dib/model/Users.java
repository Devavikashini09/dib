package com.dib.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    private int Id;

    @Column(unique = true)
    @NotBlank(message = "mail id should not be blank")
    private String email;

    @NotBlank(message = "user name  should not be blank")

    private String username;
    @NotBlank(message = "Password  should not be blank")

    private String Password;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Role> roles;

//    public Customer(String name, String password, List<GrantedAuthority> list) {
    }


