package com.jmontecinos.library.controllers;

import com.jmontecinos.library.interfaces.BookService;
import com.jmontecinos.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
    }
}
