package com.example.school_management_hw21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     @NotEmpty(message = "should be not null")
     @Column(columnDefinition = "varchar(25) NOT NULL")
    private String name;
     @NotNull(message = "should be not null")
     @Column(columnDefinition = "varchar(25) NOT NULL")
    private Integer age;
     @NotEmpty(message = "should be not null")
     @Column(columnDefinition = "varchar(25) NOT NULL")
    private String email;
     @NotNull(message = "should be not null")
     @Column(columnDefinition = "varchar(25) NOT NULL")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Course> course;
}
