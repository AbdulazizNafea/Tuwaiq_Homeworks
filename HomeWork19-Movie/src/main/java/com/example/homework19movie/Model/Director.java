package com.example.homework19movie.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Director {

    @Id
    @NotNull(message = "should be not null")
    private Integer id;

    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(25) NOT NULL")
    @Size(min = 2, message = "size more 2")
    private String name;

}
