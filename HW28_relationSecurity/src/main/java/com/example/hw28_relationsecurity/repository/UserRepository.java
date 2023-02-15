package com.example.hw28_relationsecurity.repository;

import com.example.hw28_relationsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findUserByUsername(String username);
    public User findUserById(Integer id);
}
