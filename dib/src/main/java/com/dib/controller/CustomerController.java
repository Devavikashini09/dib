package com.dib.controller;

import com.dib.constant.Constants;
import com.dib.model.Customer;
import com.dib.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    public CustomerService customerService;
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody  @NonNull Customer customer){
        String accountType = Constants.ACCOUNT_TYPE_SAVINGS;
        return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
    }
    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
        Optional<Customer> customer=customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer>updateCustomerById(@RequestBody @NonNull Customer customer){
       return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable int id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();

    }




}
