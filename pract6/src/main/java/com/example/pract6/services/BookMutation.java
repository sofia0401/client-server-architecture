package com.example.pract6.services;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.pract6.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {
    @Autowired
    private BookService bookService;
    public Book createBook(final String title, final String genre, final String author, final String language) {
        return this.bookService.createBook(title, genre, author, language);
    }

}
