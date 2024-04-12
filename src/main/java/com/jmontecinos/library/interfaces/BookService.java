package com.jmontecinos.library.interfaces;

import com.jmontecinos.library.models.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void addBook(Book book);
    void deleteBook(String isbn);
}
