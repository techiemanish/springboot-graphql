package com.graphql.learn.service;

import com.graphql.learn.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface BookService extends MongoRepository<Book, Integer> {
}
