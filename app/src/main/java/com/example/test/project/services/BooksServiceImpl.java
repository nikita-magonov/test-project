package com.example.test.project.services;

import com.example.test.project.api.dto.Book;
import com.example.test.project.data.repositories.BookRepository;
import com.example.test.project.mappers.BookDbModelToBookDtoMapper;
import com.example.test.project.mappers.BookDtoToBookDbModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BooksServiceImpl implements BooksService {

    private final BookDbModelToBookDtoMapper bookDbModelToBookDtoMapper;

    private final BookDtoToBookDbModelMapper bookDtoToBookDbModelMapper;

    private final BookRepository bookRepository;

    @Override
    public Book findBookById(UUID id) {
        Optional<com.example.test.project.data.Book> optionalBookDbModel = bookRepository.findById(id);

        if (optionalBookDbModel.isPresent()) {
            com.example.test.project.data.Book bookDbModel = optionalBookDbModel.get();

            return bookDbModelToBookDtoMapper.map(bookDbModel);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookDbModelToBookDtoMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Book saveNewBook(@RequestBody Book book) {
        com.example.test.project.data.Book bookDbModel = bookDtoToBookDbModelMapper.map(book);

        bookDbModel.setId(UUID.randomUUID());

        return bookDbModelToBookDtoMapper.map(bookRepository.save(bookDbModel));
    }
}
