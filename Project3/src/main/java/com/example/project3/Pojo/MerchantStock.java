package com.example.project3.Pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    //MerchantStock : ID , productid , merchantid , stock.

    @NotNull(message = "should be not null") @Min(value = 100, message = "id should be more than 3 numbers")
    int id;

    @NotNull(message = "should be not null") @Min(value = 100, message = "productid should be more than 3 numbers")
    int productid;

    @NotNull(message = "should be not null") @Min(value = 100, message = "merchantid should be more than 3 numbers")
    int merchantid;

    @NotNull(message = "should be not null") @Min(value = 10, message = "should be more than 10 ")
    int stock;
}
