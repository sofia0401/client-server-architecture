package com.example.pract6.services;

import com.example.pract6.models.Book;
import com.example.pract6.repos.BookRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class BookService {
    private final BookRepository bookRepository ;
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository ;
    }
    @Transactional
    public Book createBook(final String title, final String genre, final String author, final String language) {
        final Book book = new Book();
        book.setTitle(title);
        book.setGenre(genre);
        book.setAuthor(author);
        book.setLanguage(language);
        return this.bookRepository.save(book);
    }
    @Transactional(readOnly = true)
    public List<Book> getAllBooks(final int count) {
        return this.bookRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public Optional<Book> getBook(final int id) {
        return this.bookRepository.findById(id);
    }
}