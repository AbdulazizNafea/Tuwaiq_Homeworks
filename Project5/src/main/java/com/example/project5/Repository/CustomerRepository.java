package com.example.project5.Repository;

import com.example.project5.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer findCustomerById(Integer id);
}
