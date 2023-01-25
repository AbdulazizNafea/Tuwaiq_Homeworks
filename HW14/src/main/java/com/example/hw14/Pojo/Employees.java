package com.example.hw14.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
public class Employees {

    //ID : Cannot be null - Length more than 2
    @NotNull(message = "Cannot be null") @Min(value = 2, message = "size not correct")
    int id;
    //name : Cannot be null - Length more than 4
    @NotEmpty(message = "Cannot be null") @Size(min = 5, message = "main size is 5")
    String name;
    //age : Cannot be null - It has to be number - It must be more than 25
    @NotNull(message = "Cannot be null") @Min(value = 25, message = "your age should bre more than 24")
    int age;
    //position : Cannot be null - must be supervisor or coordinator only
    @NotEmpty(message = "Cannot be null") @Pattern(regexp = "(?:|\\w)supervisor(?:|\\w)|(?:|\\w)coordinator(?:|\\w)", message = "just allow to be coordinator or supervisor")
    String position;

    boolean onLeave;
//employmentYear : Cannot be null - it has to be number - must be a valid year
    //pattern for number and year sould be more than 1990 and less than today

    @Min(value = 1996, message = "Minimum is 1996") @Max(value=2023 ,message = "Max is 2023")
    int employmentYear;
    //annualLeave: Cannot be null - it has to be number
    @NotNull(message = "Cannot be null") @Min(value = 1)
    int annualLeave;

}
