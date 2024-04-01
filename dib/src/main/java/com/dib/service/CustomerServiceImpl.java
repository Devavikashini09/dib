package com.dib.service;
import com.dib.Interface.CustomerService;
import com.dib.Interface.EmailService;
import com.dib.dto.AccountInfo;
import com.dib.dto.BankResponse;
import com.dib.dto.CustomerRequest;
import com.dib.dto.EmailDetails;
import com.dib.exception.NotFoundCustomer;
import com.dib.exception.NotFoundUser;
import com.dib.model.Customer;
import com.dib.repository.CustomerRepository;
import com.dib.util.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    public EmailService emailService;

    @Override
    public BankResponse createCustomer(CustomerRequest customerRequest) {


        Customer customer = customerRepository.findByEmail(customerRequest.getEmail());
        if(customer != null) {
            // Customer with the provided email already exists
            BankResponse bankResponse = BankResponse.builder()
                    .response_code(AccountUtil.ACCOUNT_EXISTS_CODE)
                    .response_message(AccountUtil.ACCOUNT_EXISTS_MESS)
                    .accountInfo(null)
                    .build();
            // Handle the response or return it as needed
        } else {
            // Customer with the provided email does not exist
            // Proceed with creating a new customer
        }


             customer= Customer.builder()
                .first_name(customerRequest.getFirst_name())
                .last_name(customerRequest.getLast_name())
                .mobile_no(customerRequest.getMobile_no())
                .address(customerRequest.getAddress())
                .city(customerRequest.getCity())
                .state(customerRequest.getState())
                .country(customerRequest.getCountry())
                .email(customerRequest.getEmail())
                .date_of_birth(customerRequest.getDate_of_birth())
                .gender(customerRequest.getGender())
                .account_balance(BigDecimal.ZERO)
                .account_number(AccountUtil.generateAccountNumber())
                .customer_id(AccountUtil.generateCustomerId())
                .status("ACTIVE")
                .build();
        Customer savedCustomer= customerRepository.save(customer);
        //send email alert
        EmailDetails emailDetails= EmailDetails.builder()
                .recipient(savedCustomer.getEmail())
                .subject("\"Congratulations! Your New Account with Demo Indian Bank has Been Successfully Created\"")
                .message_body(" Your Account Details: \n Acoount Name: "+savedCustomer.getFirst_name() + " "+savedCustomer.getLast_name()+
                        "\nAccount Number: "+ savedCustomer.getAccount_number()+ "\nCustomer Id: "+savedCustomer.getCustomer_id())
                .build();
        emailService.sendEmailAlert(emailDetails);
        return BankResponse.builder()
                .response_code(AccountUtil.ACCOUNT_EXISTS_CODE2)
                .response_message(AccountUtil.ACCOUNT_EXISTS_MESS2)
                .accountInfo(AccountInfo.builder()
                        .account_number(savedCustomer.getAccount_number())
                        .account_balance(savedCustomer.getAccount_balance())
                        .customer_id(savedCustomer.getCustomer_id())
                        .account_name(savedCustomer.getFirst_name() + " " +savedCustomer.getLast_name())
                        .build())
                .build();
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
            throw new NotFoundCustomer();
        }
    }

    @Override
    public String deleteCustomerById(int id) {
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            Customer customer = optional.get();
            customerRepository.save(customer);
            return "Customer deleted";
        } else {
            throw new NotFoundUser();
        }

    }

}
