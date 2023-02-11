package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //id - name - phoneNumber - email (Add all required validation)
    @NotEmpty(message = "Should be not null")
    @Column(columnDefinition = "varchar(45) ",nullable = false)
    private String name;
    @NotEmpty(message = "Should be not null")
    @Column(columnDefinition = "varchar(13) ",nullable = false, unique = true)
    private String phoneNumber;
    @NotEmpty(message = "Should be not null")

    @Column(columnDefinition = "varchar(45)" ,nullable = false, unique = true)
    @Email(message = "Please enter correct E-mail")
    private String email;

    @ManyToMany
    @JsonIgnore
    private List<Store> store;

}
