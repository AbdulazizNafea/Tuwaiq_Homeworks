package com.example.hw28_relationsecurity.controller;

import com.example.hw28_relationsecurity.model.User;
import com.example.hw28_relationsecurity.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody@Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered !");
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome back");
    }

    @PostMapping("/logout")
    public ResponseEntity logout(){
        return ResponseEntity.status(HttpStatus.OK).body("logout!");
    }

    @GetMapping("/getUser")
    public ResponseEntity getUserById(@AuthenticationPrincipal User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(user.getId()));
    }

    @PutMapping("/updateUser")
    public ResponseEntity updatebyUser(@Valid @RequestBody User user,@AuthenticationPrincipal User id){
        userService.updateByUser(id.getId(), user);
        return ResponseEntity.status(HttpStatus.OK).body("your account updated");
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteByUse(@PathVariable Integer id,@AuthenticationPrincipal User auth){
        userService.deleteByUser(id,auth.getId());
        return ResponseEntity.status(HttpStatus.OK).body("your account deleted");
    }

//    @GetMapping("/gets")
//    public ResponseEntity getAll(){
//        return  ResponseEntity.status(200).body(userService.getAllUsers());
//    }
}
