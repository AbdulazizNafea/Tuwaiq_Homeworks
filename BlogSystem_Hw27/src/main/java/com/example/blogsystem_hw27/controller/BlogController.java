package com.example.blogsystem_hw27.controller;

import com.example.blogsystem_hw27.model.Blog;
import com.example.blogsystem_hw27.model.MyUser;
import com.example.blogsystem_hw27.service.BlogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {

private final BlogService blogService;

    // Admin
    @GetMapping("/all-blogs")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(blogService.getAll());
    }

    // User
    @GetMapping("/my-blogs")
    public ResponseEntity getMyBlog(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(blogService.getAllMyBlog(myUser.getId()));
    }
    // User
    @GetMapping("/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id , @AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(blogService.getById(id , myUser.getId()));
    }

    // User
    @PostMapping("/add-blog")
    public ResponseEntity addTodo(@RequestBody @Valid Blog blog, @AuthenticationPrincipal MyUser myUser){
        blogService.add(blog, myUser.getId());
        return ResponseEntity.status(201).body("Todo Added");
    }

    // User
    @PutMapping("/update/{id}")
    public ResponseEntity updateTodo(@RequestBody @Valid Blog blog, @PathVariable Integer id, @AuthenticationPrincipal MyUser myUser){
        blogService.update(blog,id,myUser.getId());
        return ResponseEntity.status(200).body("Todo Updated");
    }

    // User
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTodo(@PathVariable Integer id, @AuthenticationPrincipal MyUser myUser){
        blogService.delete(id,myUser.getId());
        return ResponseEntity.status(200).body("Todo deleted");
    }

}
