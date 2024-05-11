package com.roya.bookstore.admin;

import com.roya.bookstore.base.dao.BookDao;
import com.roya.bookstore.base.dto.BookDto;
import com.roya.bookstore.base.entities.Book;
import com.roya.bookstore.common.BookConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminBookService {
    private final BookDao bookDao;
    private final BookConverter bookConverter;


    public BookDto addBook(BookDto bookDto) {
        Book book = bookConverter.dtoToBook(bookDto);
        Book savedBook = bookDao.save(book);

        return bookConverter.bookToDto(savedBook);
    }

    public String removeBook(String bookId) {
        Book book = bookDao.findById(bookId)
                .orElseThrow();

        bookDao.delete(book);

        return book.getBookId();
    }

    public BookDto updateBook(String bookId, BookDto bookDto) {
        Book book = bookDao.findById(bookId)
                .orElseThrow();

        //update the parameters
        if(bookDto.getTitle() != null) book.setTitle(bookDto.getTitle());
        if(bookDto.getAuthor() != null) book.setAuthor(bookDto.getAuthor());
        if(bookDto.getDescription() != null) book.setDescription(bookDto.getDescription());

        Book updatedBook = bookDao.save(book);

        return bookConverter.bookToDto(updatedBook);
    }

}
