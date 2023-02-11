package com.example.project5.Controller;

import com.example.project5.Model.Book;
import com.example.project5.Service.BookServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookServices bookService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(bookService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Book book){
        bookService.add(book);
        return ResponseEntity.status(200).body("Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody @Valid Book book, @PathVariable Integer id) {
        bookService.update(book,id);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }
    //////////////////////////////////////////////////////////
    //Create endpoint that takes bookId and return number of books available
    @GetMapping("/get/book_count_By/bookID/{id}")
    public ResponseEntity getBookCount(@PathVariable Integer id){
        return ResponseEntity.status(200).body(bookService.getBookCount(id));
    }

    /////////////////////////////////////////////////////////
    //Create endpoint that takes a book name and return all book information
    @GetMapping("/get/bookByName/{name}")
    public ResponseEntity getBookByName(@PathVariable String name){
        return ResponseEntity.status(200).body(bookService.getBookByName(name));
    }
    //////////////////////////////////////////////////////////
    //Create endpoint that return all books under a specific genre
    @GetMapping("/get/bookByGnere/{genre}")
    public ResponseEntity getBookByGenre(@PathVariable String genre){
        List<Book> books = bookService.getAllBooksByGenre(genre);
        return ResponseEntity.status(200).body(books);
    }
}
