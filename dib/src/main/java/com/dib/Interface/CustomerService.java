package com.dib.Interface;

import com.dib.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public List<Customer> getCustomer();
    public Optional<Customer> getCustomerById(int id);
    Customer updateCustomerById(int id, Customer customer);
    public String deleteCustomerById(int id);


}
