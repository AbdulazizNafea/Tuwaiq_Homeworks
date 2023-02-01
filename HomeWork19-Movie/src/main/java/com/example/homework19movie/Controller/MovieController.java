package com.example.homework19movie.Controller;

import com.example.homework19movie.Model.Movie;
import com.example.homework19movie.Services.MovieServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {


    private final MovieServices movieServices;

    @GetMapping("/get")
    public ResponseEntity getMovie(){
        List<Movie> userList = movieServices.getMovie();
        return  ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie ) {

        movieServices.addMovie(movie);
        return ResponseEntity.status(200).body("added");

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie( @RequestBody @Valid Movie movie, @PathVariable Integer id){

        movieServices.updateMovie(movie,id);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieServices.deleteMovie(id);
        return ResponseEntity.status(200).body("deleted");
    }

    /////////////////////////////////////////////////////////
    @GetMapping("/getmovie/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie = movieServices.getMoveByName(name);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/getdur/{name}")
    public ResponseEntity getDurationByName(@PathVariable String name){
        int movie = movieServices.getDurationByName(name);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/getrate2/{name}")
    public ResponseEntity getRateByName(@PathVariable String name){
        int movie = movieServices.getRateByName(name);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/getDir/{name}")
    public ResponseEntity getDirectorNameByName(@PathVariable String name){
        String movie = movieServices.getDirectorNameByName(name);
        return ResponseEntity.status(200).body(movie);
    }

//    @GetMapping("/getrate/{name}")
//    public ResponseEntity getCustomeMovieByRate(@PathVariable String name){
//        int movie = movieServices.getRateByName(name);
//        return ResponseEntity.status(200).body(movie);
//    }


    @GetMapping("/getgen/{name}")
    public ResponseEntity getCustomeMovieByGenre(@PathVariable String name){
        List<Movie> movie = movieServices.getCustomeMovieByGenre(name);
        return ResponseEntity.status(200).body(movie);
    }





}
