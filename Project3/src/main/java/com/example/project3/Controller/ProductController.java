package com.example.project3.Controller;

import com.example.project3.Pojo.Product;
import com.example.project3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@SuppressWarnings("SpellCheckingInspection")

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProduct() {
        ArrayList<Product> productArrayList = productService.getProduct();
        return ResponseEntity.status(200).body(productArrayList);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("Added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@RequestBody @Valid Product product, @PathVariable int id, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        if (productService.updateProduct(product, id)) {
            return ResponseEntity.status(200).body("Updated");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        if (productService.deleteProduct(id)) {
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("id not found");
    }

}
