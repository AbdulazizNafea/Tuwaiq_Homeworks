package com.example.project5.Controller;

import com.example.project5.Model.Customer;
import com.example.project5.Service.CustomerServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServices customerServices;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(customerServices.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Customer customer){
        customerServices.add(customer);
        return ResponseEntity.status(200).body("Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody @Valid Customer customer, @PathVariable Integer id) {
        customerServices.update(customer,id);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        customerServices.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }
    //////////////////////////////////////////////////////////
}
