package com.example.test.project.controllers;

import com.example.test.project.data.repositories.BookRepository;
import com.example.test.project.dto.Book;
import com.example.test.project.mappers.BookDbModelToBookDtoMapper;
import com.example.test.project.mappers.BookDtoToBookDbModelMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/books")
public class BooksController {

    private final BookDbModelToBookDtoMapper bookDbModelToBookDtoMapper;

    private final BookDtoToBookDbModelMapper bookDtoToBookDbModelMapper;

    private final BookRepository bookRepository;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Book getBook(@PathVariable("id") UUID id) {
        Optional<com.example.test.project.data.Book> optionalBookDbModel = bookRepository.findById(id);

        if (optionalBookDbModel.isPresent()) {
            com.example.test.project.data.Book bookDbModel = optionalBookDbModel.get();

            return bookDbModelToBookDtoMapper.map(bookDbModel);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @ResponseBody
    public List<Book> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookDbModelToBookDtoMapper::map)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        com.example.test.project.data.Book bookDbModel =bookDtoToBookDbModelMapper.map(book);

        bookDbModel.setId(UUID.randomUUID());

        return bookDbModelToBookDtoMapper.map(bookRepository.save(bookDbModel));
    }
}
