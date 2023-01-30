package com.example.homework17.Controller;

import com.example.homework17.Model.UserModel;
import com.example.homework17.Services.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
       List<UserModel> userList = userService.getUsers();
        return  ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid UserModel userModel , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(userModel);
        return ResponseEntity.status(200).body("added");

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser( @RequestBody @Valid UserModel userModel, @PathVariable Integer id, Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(userModel,id);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("deleted");
    }

}
