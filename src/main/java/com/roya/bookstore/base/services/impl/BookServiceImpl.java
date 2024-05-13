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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final BookConverter bookConverter;

    @Override
    public Set<BookDto> getBooks(String genre, String author, String language) {
        Set<Book> books = new HashSet<>();
        
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
                .collect(Collectors.toSet());
    }

    @Override
    public BookDto getBook(String bookId) {
        Book book = bookDao.findById(bookId)
                .orElseThrow();

        return bookConverter.bookToDto(book);
    }

    @Override
    public BookDto buyBook(String bookId) {
        Book book = bookDao.findById(bookId)
                .orElseThrow();

        if (!book.isInStock()) {
            return null;
        }

//        add the book to the user's book list, also add the logic to checkout and payment
        book.setQuantityInStock(book.getQuantityInStock()-1);
        Book updatedBook = bookDao.save(book);

        return bookConverter.bookToDto(updatedBook);
    }

}
