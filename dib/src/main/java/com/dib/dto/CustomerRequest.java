package com.dib.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerRequest {

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
    private  String gender;

}
