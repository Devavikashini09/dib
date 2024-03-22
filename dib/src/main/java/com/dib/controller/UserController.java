package com.dib.controller;

import com.dib.model.Login;
import com.dib.model.Users;
import com.dib.service.CustomerUserDetailsService;
import com.dib.service.JwtUtilityServiceImpl;
import com.dib.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String addDetails(@Valid @RequestBody Users user){
        userService.addDetails(user);
        return ("User successfully created");

    }//registration

    @PostMapping("/login")
    public String createUser(@RequestBody Login login) {
        if (customerUserDetailsService.loadUserByUsername(login.getUsername()) == null) {
            return "Invalid credentials";
        }
        return jwtUtilityService.generateToken(login.getUsername());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable int id)
    {
        String message;
        try {
            userService.deleteUser(id);
            message = "User with ID " + id + " deleted successfully.";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Failed to delete user with ID " + id + ": " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }

    }

    @GetMapping("/registration/{username}")
    public List<Users> findCustomerByUsername(@PathVariable("username") String userName){
        return userService.findUserByUserName(userName);
    }

}
