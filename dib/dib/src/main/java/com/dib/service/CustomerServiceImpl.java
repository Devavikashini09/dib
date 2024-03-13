package com.dib.service;

import com.dib.model.Customer;
import com.dib.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    public CustomerRepository customerRepository;
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }
}
