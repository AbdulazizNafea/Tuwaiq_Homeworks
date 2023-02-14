package com.example.blogsystem_hw27.controller;

import com.example.blogsystem_hw27.model.MyUser;
import com.example.blogsystem_hw27.service.BlogService;
import com.example.blogsystem_hw27.service.MyUserDetailsService;
import com.example.blogsystem_hw27.service.MyUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final MyUserService myUserService;
    private final BlogService blogService;
    // Admin


    // All
    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody MyUser myUser){
        myUserService.add(myUser);
        return ResponseEntity.status(201).body("User Created");
    }
    //All
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(HttpStatus.OK).body("user logged in successfully");
    }
    // Admin
    @GetMapping("/all-users")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(myUserService.getAll());
    }

    // Admin
    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(myUserService.getOne(id));
    }

    // All
    @GetMapping("/my-user")
    public ResponseEntity getMyUser(@AuthenticationPrincipal MyUser auth){
        return ResponseEntity.status(200).body(myUserService.getOne(auth.getId()));
    }

    // User - No one can update another user
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody @Valid MyUser newUser, @AuthenticationPrincipal MyUser auth){
        myUserService.update(auth.getId(), newUser);
        return ResponseEntity.status(200).body("User Updated");
    }
    // Admin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        myUserService.delete(id);
        return ResponseEntity.status(200).body("User Deleted");
    }

}
