package com.example.homework19movie.Repository;

import com.example.homework19movie.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
    public Director findDirectorById(Integer id);
}
