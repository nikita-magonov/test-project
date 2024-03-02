package com.example.test.project.services;

import com.example.test.project.api.dto.Book;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface BooksService {
    Book findBookById(UUID id);

    List<Book> listBooks();

    Book saveNewBook(@RequestBody Book book);
}
