package com.example.project3.Controller;

import com.example.project3.Pojo.User;
import com.example.project3.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@SuppressWarnings("SpellCheckingInspection")

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor


public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser() {
        ArrayList<User> productArrayList = userService.getUser();
        return ResponseEntity.status(200).body(productArrayList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("Added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user, @PathVariable int id, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        if (userService.updateUser(user, id)) {
            return ResponseEntity.status(200).body("Updated");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    //================================================================
//Create endpoint where user can add product to a merchantStock
//this endpoint should accept a productid and merchantid and stock
    @PutMapping("/addstock/{userid}/{productid}/{merchantid}/{stock}")
    public ResponseEntity addStock(@PathVariable int userid, @PathVariable @Valid int productid,@PathVariable @Valid int merchantid ,@PathVariable @Valid int stock) {

        if (userService.isUserCanAddStock(userid,productid,merchantid,stock)) {
            return ResponseEntity.status(200).body("added to merchant Stock");
        }
        return ResponseEntity.status(400).body("Check entered data and try again");
    }

//============================================================================
    @PutMapping("/buyproduct/{userid}/{productid}/{merchantid}")
    public ResponseEntity buyProduct(@PathVariable int userid, @PathVariable @Valid int productid ,@PathVariable @Valid int merchantid) {

        if (userService.isUserCanBuyProduct(userid,productid,merchantid)) {
            return ResponseEntity.status(200).body("You have purchased the product");
        }
        return ResponseEntity.status(400).body("Check entered data and try again");
    }



}
