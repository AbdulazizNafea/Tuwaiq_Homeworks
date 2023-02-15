package com.example.hw28_relationsecurity.repository;

import com.example.hw28_relationsecurity.model.Order;
import com.example.hw28_relationsecurity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository  extends JpaRepository<Product,Integer> {
    public Product findProductById(Integer id);
//    public Product findAll(Order order);
}
