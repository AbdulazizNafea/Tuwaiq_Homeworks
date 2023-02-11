package com.example.project5.Service;

import com.example.project5.ApiException.ApiException;
import com.example.project5.Model.Customer;
import com.example.project5.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServices {
    private final CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public void add(Customer customer){
        customerRepository.save(customer);
    }

    public void update(Customer customer ,Integer id){
        Customer newCustomer = customerRepository.findCustomerById(id);
        if (newCustomer == null) {
            throw new ApiException("Customer ID not found");
        }
        newCustomer.setName(customer.getName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(newCustomer);
    }

    public void delete(Integer id){
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("Customer ID not found");
        }
        customerRepository.delete(customer);
    }
    /////////////////////////////////////////////////////////
}
