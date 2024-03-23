package com.graphql.learn.controller;

import com.graphql.learn.model.Book;
import com.graphql.learn.model.BookInput;
import com.graphql.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @MutationMapping("createBook")
    public Book submitBook(@Argument BookInput bookInput){
        Book book = new Book();
        book.setId(bookInput.getId());
        book.setTitle(bookInput.getTitle());
        book.setDesc(bookInput.getDesc());
        book.setAuthor(bookInput.getAuthor());
        book.setPrice(bookInput.getPrice());
        book.setPages(bookInput.getPages());
        Book result = this.bookService.save(book);
        return result;
    }

    @QueryMapping("getBookById")
    public Book getBookById(@Argument int bookId){
        Optional<Book> result = this.bookService.findById(bookId);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    @QueryMapping("getAllBooks")
    public List<Book> getAllBooks(){
        List<Book> result = this.bookService.findAll();
        return result;
    }
}
