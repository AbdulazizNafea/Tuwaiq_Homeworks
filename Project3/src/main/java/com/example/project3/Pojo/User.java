package com.example.project3.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    //User Class : id , username , password , email , role , balance.

    @NotNull(message = "should be not null") @Min(value = 100, message = "id should be more than 3 numbers")
    int id;

    @NotEmpty(message = "should be not null") @Size(min = 5, message = "username should be more than 3 letter")
    String username;
    @NotEmpty(message = "should be not null") @Size(min = 5, message = "password should be more than 3 letter")
    @Pattern(regexp = "([A-Za-z]+[0-9]|[0-9]+[A-Za-z])[A-Za-z0-9]*")
    String password;

    @NotEmpty(message = "should be not null") @Email(message = "should be correct email")
    String email;
    @NotEmpty(message = "should be not null") @Pattern(regexp = "(?:|\\w)Admin(?:|\\w)|(?:|\\w)Customer(?:|\\w)", message = "just allow to be Customer or Admin")
    String role;

    @NotNull(message = "should be not null")
    @Positive(message = "should be not positive")
    double balance;
}
