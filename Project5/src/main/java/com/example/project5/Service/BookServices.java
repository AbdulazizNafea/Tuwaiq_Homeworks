package com.example.project5.Service;

import com.example.project5.ApiException.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServices {
    private final BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void add(Book book){
        bookRepository.save(book);
    }

    public void update(Book book ,Integer id){
        Book newBook = bookRepository.findBookById(id);
        if (newBook == null) {
            throw new ApiException("Book ID not found");
        }
        newBook.setName(book.getName());
        newBook.setGenre(book.getGenre());
        newBook.setBookCount(book.getBookCount());
        bookRepository.save(newBook);
    }

    public void delete(Integer id){
        Book book = bookRepository.findBookById(id);
        if (book == null) {
            throw new ApiException("Book ID not found");
        }
        bookRepository.delete(book);
    }
    /////////////////////////////////////////////////////////
    //Create endpoint that takes bookId and return number of books available
    public int getBookCount(Integer id){
        Book book = bookRepository.findBookById(id);
        if (book == null) {
            throw new ApiException("book not found");
        }
        return book.getBookCount();
    }
    //////////////////////////////////////////////////////////
    //Create endpoint that takes a book name and return all book information
    public Book getBookByName(String name){
        Book book = bookRepository.findBookByName(name);
        if (book == null) {
            throw new ApiException("book not found");
        }
        return book;
    }
    ////////////////////////////////////////////////////////////
    //Create endpoint that return all books under a specific genre
    public List<Book> getAllBooksByGenre(String genre){
        List<Book> book = bookRepository.findBookByGenre(genre);

        if (book == null) {
            throw new ApiException("Genre not found");
        }
        return book;
    }
}
