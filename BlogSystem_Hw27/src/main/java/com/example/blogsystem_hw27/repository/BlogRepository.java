package com.example.blogsystem_hw27.repository;

import com.example.blogsystem_hw27.model.Blog;
import com.example.blogsystem_hw27.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    public Blog findBlogById(Integer id);


    public List<Blog> findAllByMyUser(MyUser myUser);

}
