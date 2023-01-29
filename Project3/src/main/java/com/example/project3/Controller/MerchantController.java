package com.example.project3.Controller;


import com.example.project3.Pojo.Merchant;
import com.example.project3.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {


    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchant() {
        ArrayList<Merchant> merchantArrayList = merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchantArrayList);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant merchant, @PathVariable int id, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        if (merchantService.updateMerchant(merchant, id)) {
            return ResponseEntity.status(200).body("Updated");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable int id) {
        if (merchantService.deleteMerchant(id)) {
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("id not found");
    }

}
