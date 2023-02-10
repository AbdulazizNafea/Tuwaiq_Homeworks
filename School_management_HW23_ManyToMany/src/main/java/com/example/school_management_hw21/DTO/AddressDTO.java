package com.example.school_management_hw21.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AddressDTO {


    private Integer id;

    // @NotEmpty(message = "should be not null")
    // @Column(columnDefinition = "varchar(25) NOT NULL")
    private String buildingNumber;
    // @NotEmpty(message = "should be not null")
    // @Column(columnDefinition = "varchar(25) NOT NULL")
    private String street;
    // @NotEmpty(message = "should be not null")
    // @Column(columnDefinition = "varchar(25) NOT NULL")
    private String area;
}
