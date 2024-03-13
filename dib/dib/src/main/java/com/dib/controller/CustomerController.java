package com.dib.controller;

import com.dib.model.Customer;
import com.dib.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    public CustomerService customerService;
    @PostMapping
    public  Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);

    }
    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }



}
