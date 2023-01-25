package com.springboot.homework13rest_crud.Controller;

import com.springboot.homework13rest_crud.Pojo.Customers;
import com.springboot.homework13rest_crud.Pojo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customers")
public class CustomersController {

    ArrayList<Customers> customerList = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Customers> getCustomers(){
        return customerList;
    }

    @PostMapping("/add")
    public String addTask (@RequestBody Customers customers){
        customerList.add(customers);
        return "added";
    }

    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index, @RequestBody Customers customers){
        customerList.set(index,customers);
        return "updated";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index){
        customerList.remove(index);
        return "deleted";
    }

    @PutMapping("/deposit/{id}/{plus}")
    public String deposit(@PathVariable int id,@PathVariable double plus){

        double result;
            for(Customers i: customerList){
                if(i.getId() == id){
                   // return i.getUsername();
                    if(plus>0){
                        result = plus + i.getBalance();
                        i.setBalance(result);
                        return "money added successful";
                    }
                    return "wrong deposit";
                }
                return "user id not found";
        }
            return "not added";
    }

    @PutMapping("/withdraw/{id}/{plus}")
    public String withdraw(@PathVariable int id,@PathVariable double plus){

        double result;
        for(Customers i: customerList){
            if(i.getId() == id){
                // return i.getUsername();
                if(i.getBalance() - plus >= 0){
                    result = i.getBalance() - plus;
                    i.setBalance(result);
                    return "withdraw successful";
                }
                return "your balance Not enough";
            }
            return "user id not found";
        }
        return "withdraw not happen";
    }

}
