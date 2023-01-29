package com.example.project3.Controller;

import com.example.project3.Pojo.MerchantStock;
import com.example.project3.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/ms")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock() {
        ArrayList<MerchantStock> productArrayList = merchantStockService.getMerchantStock();
        return ResponseEntity.status(200).body(productArrayList);
    }

    @PostMapping("/add")
    public ResponseEntity adMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("Added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock, @PathVariable int id, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        if (merchantStockService.updateMerchantStock(merchantStock, id)) {
            return ResponseEntity.status(200).body("Updated");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id) {
        if (merchantStockService.deleteMerchantStock(id)) {
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("id not found");
    }


}
