package com.example.school_management_hw21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
   private Integer id;
    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(25) NOT NULL")
   private String area;
    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(25) NOT NULL")
   private String street;
    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(25) NOT NULL")
   private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
