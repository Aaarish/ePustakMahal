package com.roya.bookstore.base.controllers;

import com.roya.bookstore.base.dto.BookDto;
import com.roya.bookstore.base.services.BookService;
import com.roya.bookstore.common.GenericResponse;
import com.roya.bookstore.enums.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    /*
    list categories, list books by category, buy a book
     */

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<GenericResponse> getBooks(@RequestParam(value = "genre", required = false) String genre,
                                                    @RequestParam(value = "author", required = false) String author,
                                                    @RequestParam(value = "language", required = false) String language) {
        Set<BookDto> allBooks = bookService.getBooks(genre, author, language);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(GenericResponse.builder()
                        .source(null)
                        .responseStatus(ResponseStatus.SUCCESS)
                        .responseBody(allBooks)
                        .build());
    }


    @GetMapping("/{bookId}")
    public ResponseEntity<GenericResponse> getBook(@PathVariable String bookId) {
        BookDto book = bookService.getBook(bookId);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(GenericResponse.builder()
                        .source(null)
                        .responseStatus(ResponseStatus.SUCCESS)
                        .responseBody(book)
                        .build());
    }

}
