package com.example.project5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Should be not null")
    @Column(columnDefinition = "varchar(45) ",nullable = false, unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL , mappedBy ="store")
    @PrimaryKeyJoinColumn
    Location location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private List<Book> book;

    @ManyToMany(cascade = CascadeType.REMOVE ,mappedBy = "store")
    private List<Customer> customer;

}
