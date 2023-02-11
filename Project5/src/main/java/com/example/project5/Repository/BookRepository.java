package com.example.project5.Repository;

import com.example.project5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    public Book findBookById(Integer id);
    public Book findBookByName(String name);
    public List<Book> findBookByGenre(String genre);
}
