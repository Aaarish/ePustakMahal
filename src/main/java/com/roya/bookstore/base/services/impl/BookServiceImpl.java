package com.roya.bookstore.base.services.impl;

import com.roya.bookstore.base.dao.BookDao;
import com.roya.bookstore.base.dto.BookDto;
import com.roya.bookstore.base.entities.Book;
import com.roya.bookstore.base.services.BookService;
import com.roya.bookstore.common.BookConverter;
import com.roya.bookstore.enums.CategoryType;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final BookConverter bookConverter;

    @Override
    public List<BookDto> getBooks(String genre, String author, String language) {
        List<Book> books = new ArrayList<>();
        
        if(genre != null && !Strings.isEmpty(genre)) {
            books.addAll(bookDao.getBooksWithGenre(genre));
        }

        if(author != null && !Strings.isEmpty(author)) {
            books.addAll(bookDao.getBooksWithAuthor(author));
        }

        if(language != null && !Strings.isEmpty(language)) {
            books.addAll(bookDao.getBooksWithLanguage(language));
        }

        return books.stream()
                .map(bookConverter::bookToDto)
                .toList();
    }

    @Override
    public BookDto getBook(String bookId) {
        Book book = bookDao.findById(bookId)
                .orElseThrow();

        return bookConverter.bookToDto(book);
    }

}
