package com.roya.bookstore.base.services;


import com.roya.bookstore.base.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getBooks(String genre, String author, String language);

    BookDto getBook(String bookId);

}
