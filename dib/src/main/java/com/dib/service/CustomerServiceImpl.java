package com.dib.service;

import com.dib.Interface.CustomerService;
import com.dib.model.Customer;
import com.dib.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    public CustomerRepository customerRepository;
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
       return customerRepository.findById(id);
    }


    @Override
    public Customer updateCustomerById(int id, Customer customer) {
        if(customerRepository.existsById(id)){
            customer.setId(id);
            return customerRepository.save(customer);
        }
        else{
            throw new RuntimeException("Customer not found with"+ id);
        }
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);

    }

}
