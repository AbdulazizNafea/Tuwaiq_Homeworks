package com.example.hw28_relationsecurity.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name sould be not null")
    private String name;

    @NotNull(message = "price should be not null")
    private double price;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "product")
    private List<Order> order;

}
