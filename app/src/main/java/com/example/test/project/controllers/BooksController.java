package com.example.test.project.controllers;

import com.example.test.project.api.BooksApi;
import com.example.test.project.api.dto.Book;
import com.example.test.project.services.BooksService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/books")
public class BooksController implements BooksApi {

    private final BooksService booksService;

    @Override
    @GetMapping(path = "/{id}")
    @ResponseBody
    public Book getBook(@PathVariable("id") UUID id) {
        return booksService.findBookById(id);
    }

    @Override
    @GetMapping
    @ResponseBody
    public List<Book> getBooks() {
        return booksService.listBooks();
    }

    @Override
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        return booksService.saveNewBook(book);
    }
}
