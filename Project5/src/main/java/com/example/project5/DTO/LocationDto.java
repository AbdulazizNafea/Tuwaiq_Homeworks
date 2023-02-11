package com.example.project5.DTO;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationDto {
    private Integer store_id;
    @NotEmpty(message = "name Should be not null")
    private String area;
    @NotEmpty(message = "name Should be not null")
    private String street;

}
