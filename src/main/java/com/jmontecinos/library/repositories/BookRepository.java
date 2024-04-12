package com.jmontecinos.library.repositories;

import com.jmontecinos.library.models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private static List<Book> books = new ArrayList<>();

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        for (Book existingBook : books) {
            if (existingBook.getIsbn().equals(book.getIsbn())) {
                existingBook.setTitle(book.getTitle());
                return;
            }
        }
        books.add(book);
    }

    public void deleteBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
