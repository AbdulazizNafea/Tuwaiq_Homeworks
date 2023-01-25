package com.springboot.homework13rest_crud.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {

//    ID , title , des , status
    int id;
    String title;
    String des;
    String status;
}
