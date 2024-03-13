package com.dib.service;

import com.dib.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public List<Customer> getCustomer();
}
