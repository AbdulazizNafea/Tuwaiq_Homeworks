package com.example.homework19movie.Services;

import com.example.homework19movie.Model.Director;
import com.example.homework19movie.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServices {


    private final DirectorRepository directorRepository;

    public List<Director> getDirector(){
        return directorRepository.findAll();
    }

    public void addDirector(Director director){
        directorRepository.save(director);
    }


    public boolean updateDirector(Director director, Integer id){
        Director director2 = directorRepository.findDirectorById(id);
        director2.setName(director.getName());
        return true;
    }


    public  boolean deleteDirector(Integer id){
        Director director = directorRepository.getById(id);
        directorRepository.delete(director);
        return true;
    }



}
