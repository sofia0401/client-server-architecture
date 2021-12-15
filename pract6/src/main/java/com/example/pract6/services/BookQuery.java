package com.example.pract6.services;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.pract6.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class BookQuery implements GraphQLQueryResolver {
    @Autowired
    private BookService bookService;
    public List<Book> getBooks(final int count) {
        return this.bookService.getAllBooks(count);
    }
    public Optional<Book> getBook(final int id) {
        return this.bookService.getBook(id);
    }
}