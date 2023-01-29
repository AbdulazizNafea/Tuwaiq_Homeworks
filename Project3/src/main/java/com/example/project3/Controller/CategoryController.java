package com.example.project3.Controller;

import com.example.project3.Pojo.Category;
import com.example.project3.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategory() {
        ArrayList<Category> categoresList = categoryService.getCategories();
        return ResponseEntity.status(200).body(categoresList);
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@RequestBody @Valid Category category, @PathVariable int id, Errors errors) {
        if(errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }

        if (categoryService.updateCategory(category, id)) {
            return ResponseEntity.status(200).body("Updated");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id) {
        if (categoryService.deleteCategory(id)) {
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("id not found");
    }
}
