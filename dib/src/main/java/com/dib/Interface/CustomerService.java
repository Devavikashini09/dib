package com.dib.Interface;

import com.dib.dto.BankResponse;
import com.dib.dto.CustomerRequest;
import com.dib.model.Customer;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public BankResponse createCustomer(CustomerRequest customerRequest);

    public List<Customer> getCustomer();
    public Optional<Customer> getCustomerById(int id);
    Customer updateCustomerById(int id, Customer customer);
    public String deleteCustomerById(int id);


}
