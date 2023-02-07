package com.example.school_management_hw21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JoinColumn(name = "course_id" , referencedColumnName = "id")
    private Teacher teacher;
}
