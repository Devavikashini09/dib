package com.dib.controller;

import com.dib.model.Login;
import com.dib.model.Users;
import com.dib.service.CustomerUserDetailsService;
import com.dib.service.JwtUtilityServiceImpl;
import com.dib.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    private JwtUtilityServiceImpl jwtUtilityService;

    @PostMapping("/signup")
    public Users addDetails(@Valid @RequestBody Users user){
        return userService.addDetails(user);
    }//registration

    @PostMapping("/login")
    public String createUser(@RequestBody Login login) {
        if (customerUserDetailsService.loadUserByUsername(login.getUsername()) == null) {
            return "Invalid credentials";
        }
        return jwtUtilityService.generateToken(login.getUsername());
    }

    @GetMapping("/registration/{username}")
    public List<Users> findCustomerByUsername(@PathVariable("username") String userName){
        return userService.findUserByUserName(userName);
    }

}
