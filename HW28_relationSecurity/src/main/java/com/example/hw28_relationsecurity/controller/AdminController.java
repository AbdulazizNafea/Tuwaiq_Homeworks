package com.example.hw28_relationsecurity.controller;

import com.example.hw28_relationsecurity.model.Order;
import com.example.hw28_relationsecurity.model.Product;
import com.example.hw28_relationsecurity.model.User;
import com.example.hw28_relationsecurity.service.OrderService;
import com.example.hw28_relationsecurity.service.ProductService;
import com.example.hw28_relationsecurity.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;

    //// user
    @GetMapping("/get-all/user")
    public ResponseEntity getAll(@AuthenticationPrincipal User user){
        return  ResponseEntity.status(200).body(userService.getAllUsers());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody@Valid User user){
        userService.update(id,user);
        return  ResponseEntity.status(200).body("user account updated ");
    }

    ///Order
   @GetMapping("/get-all/Order")
    public ResponseEntity getAllOrder(@AuthenticationPrincipal User user){
        return  ResponseEntity.status(200).body(orderService.getAllOrder());
    }
    @PutMapping("/update/order/{id}")
    public ResponseEntity updateOrder(@AuthenticationPrincipal User user,@PathVariable Integer id,@RequestBody @Valid Order order) {
        orderService.updateOrder(order,user.getId(),id);
        return  ResponseEntity.status(200).body("you have update user account");

    }

    ///Product
    @PostMapping("/add/product")
    public ResponseEntity addProduct(@Valid @RequestBody Product product){
        productService.addProduct(product);
        return  ResponseEntity.status(HttpStatus.CREATED).body("product added");
    }

    @PutMapping("/update/product/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @Valid @RequestBody Product product){
        productService.updateProduct(id,product);
        return  ResponseEntity.status(HttpStatus.OK).body("product updated");
    }

    @DeleteMapping("/delete/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return  ResponseEntity.status(HttpStatus.OK).body("product deleted");
    }

}
