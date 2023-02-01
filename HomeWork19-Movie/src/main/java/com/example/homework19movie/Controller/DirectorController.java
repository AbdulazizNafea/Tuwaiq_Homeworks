package com.example.homework19movie.Controller;


import com.example.homework19movie.Model.Director;
import com.example.homework19movie.Services.DirectorServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorServices directorServices;

    @GetMapping("/get")
    public ResponseEntity getDirector(){
        List<Director> userList = directorServices.getDirector();
        return  ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@RequestBody @Valid Director director ) {

        directorServices.addDirector(director);
        return ResponseEntity.status(200).body("added");

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector( @RequestBody @Valid Director director, @PathVariable Integer id){

        directorServices.updateDirector(director,id);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id){
        directorServices.deleteDirector(id);
        return ResponseEntity.status(200).body("deleted");
    }

    /////////////////////////////////////////////////////////////////




}
