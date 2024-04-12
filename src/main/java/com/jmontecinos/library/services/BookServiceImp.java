package com.jmontecinos.library.services;

import com.jmontecinos.library.interfaces.BookService;
import com.jmontecinos.library.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImp implements BookService {
    private static List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void deleteBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }
}
