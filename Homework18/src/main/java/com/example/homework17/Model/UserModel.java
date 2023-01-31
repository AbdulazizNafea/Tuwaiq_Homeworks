package com.example.homework17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    //ID , name , username , password, email ,role, age
    @NotEmpty(message = "should be not null")@Size(min = 4, message = "size more 4")
    @Column(columnDefinition = "varchar(35) NOT NULL")
    private String name;
    @NotEmpty(message = "should be not null")@Size(min = 4, message = "size more 4")
    @Column(columnDefinition = "varchar(35) NOT NULL")
    private String username;

    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(35) NOT NULL")
    private String password;


    @NotEmpty(message = "should be not null")@Size(min = 4, message = "size more 4")
    @Column(columnDefinition = "varchar(50) unique")@Email(message = "should be email")
    private String email;

    @NotEmpty(message = "should be not null")
    @Pattern(regexp = "(?:|\\w)user(?:|\\w)|(?:|\\w)admin(?:|\\w)", message = "just allow to be user or admin")
   // @Column(columnDefinition = "varchar(6) NOT NULL check (gender='user' or gender= 'admin')")
    private String role;

    @NotNull(message = "should be not null")
    //@Min(value = 1)
    private Integer age;
}
