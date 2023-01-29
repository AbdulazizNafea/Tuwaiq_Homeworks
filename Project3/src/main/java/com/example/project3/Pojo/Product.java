package com.example.project3.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    //Product Class: ID, name, price , categoryID.

    @NotNull(message = "should be not null") @Min(value = 100, message = "id should be more than 3 numbers")
    int id;

    @NotEmpty(message = "should be not null") @Size(min = 3, message ="Product name should be more than 3 letter")
    String name;

    @NotNull(message = "should be not null")
    @Positive(message = "should be not positive")
    double price;

    @NotNull(message = "should be not null")  @Min(value = 100, message = "categoryID should be more than 3 numbers")
    int categoryID;
}
