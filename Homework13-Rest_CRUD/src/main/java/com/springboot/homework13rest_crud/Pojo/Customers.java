package com.springboot.homework13rest_crud.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    //ID , Username , Balance

    int id;
    String username;
    double balance;
}
