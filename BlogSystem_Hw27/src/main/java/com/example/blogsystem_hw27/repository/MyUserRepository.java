package com.example.blogsystem_hw27.repository;

import com.example.blogsystem_hw27.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    public MyUser findMyUserById(Integer id);

    public MyUser findMyUserByUsername(String userName);
}
