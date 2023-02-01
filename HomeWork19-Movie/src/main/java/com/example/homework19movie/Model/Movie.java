package com.example.homework19movie.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    //@NotEmpty(message = "should be not null")
    private Integer id;

    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(25) NOT NULL")
    @Size(min = 2, message = "size more 2")
    private String name;

    @NotEmpty(message = "should be not null")
    @Pattern(regexp = "(?:|\\w)Drama(?:|\\w)|(?:|\\w)Action(?:|\\w)|(?:|\\w)Comedy(?:|\\w)", message = "just allow to be user or admin")
    @Column(columnDefinition = "varchar(25) NOT NULL check (genre='Comedy' or genre= 'Action' or genre='Drama')")
    private String genre;

    @NotNull(message = "should be not null")
    @Column(columnDefinition = " int NOT NULL")
    @Min(value = 1)@Max(value = 5)
    private int rating;

    @NotNull(message = "should be not null")
    @Min(value=60)
    @Column(columnDefinition = "int NOT NULL")
    private int duration;


    //@GeneratedValue(strategy = GenerationType.IDENTITY )
    @NotNull(message = "should be not null")
    private int directorID;

}
