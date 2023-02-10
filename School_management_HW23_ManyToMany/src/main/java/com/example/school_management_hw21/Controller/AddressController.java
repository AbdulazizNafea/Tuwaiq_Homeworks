package com.example.school_management_hw21.Controller;


import com.example.school_management_hw21.DTO.AddressDTO;
import com.example.school_management_hw21.Model.Address;
import com.example.school_management_hw21.Services.AddressServices;
import com.example.school_management_hw21.Services.TeacherServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/a")
@RequiredArgsConstructor
public class AddressController {

    private final TeacherServices teacherServices;

    private  final AddressServices addressServices;

    @GetMapping("/getAll")
    public List<Address> getAll(){
        return addressServices.getAll();
    }
    @PostMapping("/addAddress")
    public ResponseEntity addAddress(@RequestBody AddressDTO addressDTO){
        addressServices.addAddress(addressDTO);
        return   ResponseEntity.status(200).body("Add Address Done");
    }

    @PutMapping("/updateA")
    public ResponseEntity updateAddress(@RequestBody  AddressDTO ad){
        if (addressServices.updateAddress(ad)) {
            addressServices.updateAddress(ad);
            return ResponseEntity.status(200).body("User address updated");
        }
        return ResponseEntity.status(400).body("User not found");

    }
    @DeleteMapping("/deleteA/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        if (addressServices.deleteAddress(id)) {
            addressServices.deleteAddress(id);
            return ResponseEntity.status(200).body("user address delete");
        }
        return ResponseEntity.status(400).body("User not found");

    }

}
