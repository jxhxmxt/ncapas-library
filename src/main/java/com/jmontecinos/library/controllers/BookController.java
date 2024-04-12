package com.jmontecinos.library.controllers;

import com.jmontecinos.library.interfaces.BookService;
import com.jmontecinos.library.models.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addBook(@Valid @RequestBody Book book) {
        if (bookService.findBookByIsbn(book.getIsbn()) != null) {
            return ResponseEntity.badRequest().body("Book with ISBN " + book.getIsbn() + " already exists.");
        }

        bookService.addBook(book);

        return ResponseEntity.ok("Book added successfully.");
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable String isbn) {
        if (bookService.findBookByIsbn(isbn) == null) {
            return ResponseEntity.badRequest().body("Book with ISBN " + isbn + " does not exist.");
        }

        bookService.deleteBook(isbn);

        return ResponseEntity.ok("Book deleted successfully.");
    }
}
