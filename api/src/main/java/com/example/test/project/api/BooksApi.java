package com.example.test.project.api;

import com.example.test.project.api.dto.Book;

import java.util.List;
import java.util.UUID;

public interface BooksApi {
    Book getBook(UUID id);

    List<Book> getBooks();

    Book postBook(Book book);
}
