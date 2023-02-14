package com.example.blogsystem_hw27.model;

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
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String title;
    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(500)", nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "userId" , referencedColumnName = "id")
    @JsonIgnore
    private MyUser myUser;
}
