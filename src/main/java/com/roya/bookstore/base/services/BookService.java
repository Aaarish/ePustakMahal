package com.roya.bookstore.base.services;


import com.roya.bookstore.base.dto.BookDto;

import java.util.Set;

public interface BookService {
    Set<BookDto> getBooks(String genre, String author, String language);

    BookDto getBook(String bookId);

    BookDto buyBook(String bookId);
}
