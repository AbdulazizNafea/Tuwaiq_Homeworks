package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    //id - name - bookCount - genre
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name Should be not null")
    @Column(columnDefinition = "varchar(45) ",nullable = false, unique = true)
    private String name;
    @NotNull(message = "book count Should be not null")
    @Column(nullable = false)
    private Integer bookCount;
    @NotEmpty(message = "genre Should be not null")
    @Column(columnDefinition = "varchar(45) ",nullable = false)
    private String genre;


    @ManyToOne
    @JoinColumn(name = "store_id",referencedColumnName = "id")
    @JsonIgnore
    private Store store;
}
