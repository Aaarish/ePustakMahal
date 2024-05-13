package com.roya.bookstore.common;

import com.roya.bookstore.base.dto.BookDto;
import com.roya.bookstore.base.entities.Book;
import com.roya.bookstore.enums.CategoryType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

import static com.roya.bookstore.enums.CategoryType.*;

@Service
@RequiredArgsConstructor
public class BookConverter {

    public BookDto bookToDto (Book book) {
        return BookDto.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .pages(book.getPages())
                .description(book.getDescription())
                .isInStock(book.isInStock())
                .quantityInStock(book.getQuantityInStock())
                .authorCategory(book.getAuthorCategory())
                .languageCategory(book.getLanguageCategory())
                .genreCategory(book.getGenreCategory())
                .build();
    }

    public Book dtoToBook (BookDto bookDto) {
        return Book.builder()
                .bookId(bookDto.getBookId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .pages(bookDto.getPages())
                .description(bookDto.getDescription())
                .isInStock(bookDto.isInStock())
                .authorCategory(bookDto.getAuthorCategory())
                .languageCategory(bookDto.getLanguageCategory())
                .genreCategory(bookDto.getGenreCategory())
                .build();
    }

}
