package com.example.homework19movie.Services;

import com.example.homework19movie.Model.Director;
import com.example.homework19movie.Model.Movie;
import com.example.homework19movie.Repository.DirectorRepository;
import com.example.homework19movie.Repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServices {


    private final MovieRepo movieRepoistory;
    private final DirectorRepository directorRepository;

    public List<Movie> getMovie() {
        return movieRepoistory.findAll();
    }

    public void addMovie(Movie movie){
        movieRepoistory.save(movie);
    }


    public boolean updateMovie(Movie movie, Integer id) {
        Movie movie2 = movieRepoistory.findMovieById(id);
        movie2.setName(movie.getName());
        return true;
    }


    public boolean deleteMovie(Integer id) {
        Movie movie = movieRepoistory.getById(id);
        movieRepoistory.delete(movie);
        return true;
    }

    //////////////////////////////////////////////////////////

    public Movie getMoveByName(String name) {
        Movie movie = movieRepoistory.findMovieByName(name);
        return movie;
    }

    public int getDurationByName(String name) {
        Movie movie = movieRepoistory.findMovieByName(name);
        return movie.getDuration();
    }

    public String getDirectorNameByName(String name) {
        Movie movie = movieRepoistory.findMovieByName(name);
        int directorid = movie.getDirectorID();
        Director director= directorRepository.findDirectorById(directorid);
        return director.getName();
    }


    public int getRateByName(String name) {
        Movie movie = movieRepoistory.findMovieByName(name);
        return movie.getRating();
    }

    public List<Movie> getCustomeMovieByRate(int rate){
        List<Movie> movieList= movieRepoistory.findMyCustomeRate(rate);
        return movieList;
    }

    public List<Movie> getCustomeMovieByGenre(String genre){
        List<Movie> movieList= movieRepoistory.findMovieByGenre(genre);
        return movieList;
    }

    ///////////////////////////////////






}

