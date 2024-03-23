package com.graphql.learn.controller;

import com.graphql.learn.model.Book;
import com.graphql.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/api/books")
    public ResponseEntity<?> submitBook(@RequestBody Book book){
        Book result = this.bookService.save(book);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @GetMapping("/api/books/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId){
        Optional<Book> result = this.bookService.findById(bookId);
        if(result.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(result.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Book Found with this book Id: "+ bookId);
        }
    }

    @GetMapping("/api/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> result = this.bookService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
