package com.example.hw28_relationsecurity.controller;

import com.example.hw28_relationsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/get-all/product")
    public ResponseEntity getAllProduct(){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }
    @GetMapping("/get/product/{id}")
    public ResponseEntity getProduct(@PathVariable Integer id ){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }
}
