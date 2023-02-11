package com.example.project5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Location {


    @Id
    private Integer id;
    @NotEmpty(message = "Should be not null")
    //@Column(columnDefinition = "varchar(50) ", nullable = false)
    private String area;
    @NotEmpty(message = "Should be not null")
    //@Column(columnDefinition = "varchar(50) ", nullable = false)
    private String street;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;
}
