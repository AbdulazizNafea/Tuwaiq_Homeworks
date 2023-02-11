package com.example.project5.Controller;

import com.example.project5.Model.Store;
import com.example.project5.Service.StoreServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreServices storeServices;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(storeServices.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Store store){
        storeServices.add(store);
        return ResponseEntity.status(200).body("Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody @Valid Store store, @PathVariable Integer id) {
        storeServices.update(store,id);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        storeServices.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }
    //////////////////////////////////////////////////////////
    @DeleteMapping("/del/{id}")
    public ResponseEntity del(@PathVariable Integer id) {
        storeServices.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }

    //add book to store
    @PutMapping("/add/book/{bookId}/store/{storeId}")
    public ResponseEntity assignBookToStore(@PathVariable Integer bookId, @PathVariable Integer storeId){
        storeServices.addBookToStore(bookId,storeId);
        return ResponseEntity.status(200).body("Your book added in Store");
    }

    //add customer to store
    @PutMapping("/add/customer/{customerId}/store/{store_id}")
    public ResponseEntity assignCustomerToStore(@PathVariable Integer customerId, @PathVariable Integer store_id){
        storeServices.addCustomerToStore(customerId,store_id);
        return ResponseEntity.status(200).body("Customer added to store");
    }

    //Create endpoint that takes storeid and return all the books
    @GetMapping("/getAllBook/store_id/{store_id}")
    public ResponseEntity getAllBooks(@PathVariable Integer store_id){
        return ResponseEntity.status(200).body( storeServices.getAllBooks(store_id));
    }

    //Create endpoint thar takes storeid and return all customers
    @GetMapping("/getAllCustomers/store_id/{store_id}")
    public ResponseEntity getAllCustomers(@PathVariable Integer store_id){
        return ResponseEntity.status(200).body( storeServices.getAllCustomers(store_id));
    }
}
