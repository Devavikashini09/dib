package com.dib.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "accounts")

public class Account {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(unique = true,length = 11)
    private Long account_number;

    @NotNull
    private String account_type;

    @JoinColumn(name = "branch_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Branch branch;

    @NotNull
    private Long balance;

    private Date opening_date;

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
