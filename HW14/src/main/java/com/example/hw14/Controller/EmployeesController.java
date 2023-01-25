package com.example.hw14.Controller;

import com.example.hw14.Api.ApiResponse;
import com.example.hw14.Pojo.Employees;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeesController {

    ArrayList<Employees> employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employees> getEmployees() {
        return employees;
    }


    @PostMapping("/add")
    public ResponseEntity addEmployees(@RequestBody @Valid Employees employee, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployees(@PathVariable int index, @RequestBody @Valid Employees employee, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        if (index <= employees.size() && index >= 0) {
            employees.set(index, employee);
            return ResponseEntity.status(200).body(new ApiResponse("Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("index not found"));
    }


    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployees (@PathVariable int index){
        if (index <= employees.size() && index >= 0) {
            employees.remove(index);
            return ResponseEntity.status(200).body(new ApiResponse("removed"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("index not found"));
    }


    @PutMapping("/leave/{id}/{days}")
    public ResponseEntity updateLeave(@PathVariable int id, @PathVariable int days){

        for (Employees i : employees) {
            if (i.getId() == id) {
                if (!i.isOnLeave()) {
                    if (i.getAnnualLeave() > 0 && i.getAnnualLeave() > days && days > 0) {
                        int annualLeaves = i.getAnnualLeave() - days;
                        i.setAnnualLeave(annualLeaves);
                        i.setOnLeave(true);
                        return ResponseEntity.status(200).body(new ApiResponse("Annual leave updated to: "+i.getAnnualLeave()));
                    }
                    return ResponseEntity.status(400).body(new ApiResponse("your balance not enough"));
                }
                return ResponseEntity.status(400).body(new ApiResponse("User already on leave"));
            }
        }
        return ResponseEntity.status(200).body(new ApiResponse("test"));
    }
}

