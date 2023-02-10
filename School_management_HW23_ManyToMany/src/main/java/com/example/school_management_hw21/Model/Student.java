package com.example.school_management_hw21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(45) NOT NULL")
    private String name;
    @NotNull(message = "should be not null")
    @Column(columnDefinition = "varchar(25) NOT NULL")
    private Integer age;
    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(45) NOT NULL")
    private String major;


    @ManyToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Course> course;
}
