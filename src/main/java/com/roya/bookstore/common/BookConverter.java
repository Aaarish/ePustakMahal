package com.roya.bookstore.common;

import com.roya.bookstore.base.dao.AuthorCategoryDao;
import com.roya.bookstore.base.dao.GenreCategoryDao;
import com.roya.bookstore.base.dao.LanguageCategoryDao;
import com.roya.bookstore.base.dto.BookDto;
import com.roya.bookstore.base.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.roya.bookstore.enums.CategoryType.*;

@Service
@RequiredArgsConstructor
public class BookConverter {
    private final AuthorCategoryDao authorCategoryDao;
    private final LanguageCategoryDao languageCategoryDao;
    private final GenreCategoryDao genreCategoryDao;

    public BookDto bookToDto (Book book) {
        return BookDto.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .pages(book.getPages())
                .description(book.getDescription())
                .isInStock(book.isInStock())
                .authorCategory(book.getAuthorCategory().getCategoryType().toString())
                .languageCategory(book.getLanguageCategory().getCategoryType().toString())
                .genreCategory(book.getGenreCategory().getCategoryType().toString())
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
                .authorCategory(authorCategoryDao.findByCategoryType(AUTHOR).orElseThrow())
                .languageCategory(languageCategoryDao.findByCategoryType(LANGUAGE).orElseThrow())
                .genreCategory(genreCategoryDao.findByCategoryType(GENRE).orElseThrow())
                .build();
    }

}
