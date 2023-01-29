package com.example.project3.Pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
   // Category : ID , name.

    @NotNull(message = "should be not null") @Min(value =100, message = "id should be more than 3 numbers")
    int id;

    @NotEmpty(message = "should be not null") @Size(min = 3, message ="Category name should be more than 3 letter")
    String name;


}
