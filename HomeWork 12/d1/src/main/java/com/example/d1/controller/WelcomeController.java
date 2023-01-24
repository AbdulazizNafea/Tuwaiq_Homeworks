package com.example.d1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/name")
    public String getName(){
        return "my name is: Abdulaziz";
    }

    @GetMapping("/age")
    public String getAge(){
        return "My age is: 26";
    }

    @GetMapping("/check/status")
    public String getStatus(){
        return "Everything OK";
    }

    @GetMapping("/health")
    public String getHelath(){
        return "Server health is up and running";
    }
}
