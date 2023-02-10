package com.example.school_management_hw21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "not null")
    @Column(columnDefinition = "varchar(25) NOT NULL")
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "teacher_id" , referencedColumnName = "id")
    private Teacher teacher;


    @ManyToMany
    @JsonIgnore
    private List<Student> student;
}
