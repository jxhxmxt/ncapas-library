package com.jmontecinos.library.services;

import com.jmontecinos.library.interfaces.BookService;
import com.jmontecinos.library.models.Book;
import com.jmontecinos.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    @Override
    public void deleteBook(String isbn) {
        bookRepository.deleteBook(isbn);
    }
}
