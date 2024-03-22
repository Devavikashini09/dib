package com.dib.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import java.util.List;

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
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password  should not be blank")
    private String Password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;

    public Users(String name, String password, List<GrantedAuthority> list) {
    }
}


