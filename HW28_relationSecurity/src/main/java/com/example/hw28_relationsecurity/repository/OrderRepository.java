package com.example.hw28_relationsecurity.repository;

import com.example.hw28_relationsecurity.model.Order;
import com.example.hw28_relationsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    public Order findOrderById(Integer id);
    public List<Order> findAllByUser(User user);
}
