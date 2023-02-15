package com.example.hw28_relationsecurity.controller;

import com.example.hw28_relationsecurity.model.Order;
import com.example.hw28_relationsecurity.model.Product;
import com.example.hw28_relationsecurity.model.User;
import com.example.hw28_relationsecurity.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/get-my")
    public ResponseEntity getMyOrder(@AuthenticationPrincipal User user) {
        return ResponseEntity.status(200).body(orderService.getMyOrder(user.getId()));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity order(@AuthenticationPrincipal User user, @PathVariable Integer orderId) {
        return ResponseEntity.status(200).body(orderService.getOrderById(user.getId(), orderId));

    }

    @PostMapping("/add/order/{productId}")
    public ResponseEntity addOrder(@AuthenticationPrincipal User user, @RequestBody @Valid Order order, @PathVariable Integer productId) {
        orderService.addOrder(order, user.getId(), productId);
        return ResponseEntity.status(200).body("Added");
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity deleteOrder(@AuthenticationPrincipal User user, @PathVariable Integer orderId) {
        orderService.deleteOrder(user.getId(),orderId);
        return ResponseEntity.status(200).body("deleted");
    }
}
