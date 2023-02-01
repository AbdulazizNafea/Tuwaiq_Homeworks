package com.example.homework19movie.Repository;

import com.example.homework19movie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {

    public Movie findMovieById(Integer id);

    public Movie findMovieByName(String name);

    @Query("select rate from  Movie rate where rate.rating > ?1")
    public List<Movie> findMyCustomeRate(int rate);

    public List<Movie> findMovieByGenre(String genre);



}
