package com.example.hw28_relationsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order2")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "quantity should be not null")
    //@Column(nullable = false)
    private Integer quantity;

    private double totalPrice;
    @Column(columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP()")
    private String dateReceived;
    //@Column(columnDefinition = "check ( status='inProgress' or status='completed' or status='new')")
    private String status;


    //order product -> many to many

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName ="id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    @JsonIgnore
    private Product product;

}
