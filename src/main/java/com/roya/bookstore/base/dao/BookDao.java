package com.roya.bookstore.base.dao;

import com.roya.bookstore.base.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, String> {
    @Query(value = "SELECT * FROM BOOKS WHERE genre_category = $1", nativeQuery = true)
    List<Book> getBooksWithGenre(String genre);

    @Query(value = "SELECT * FROM BOOKS WHERE author_category = $1", nativeQuery = true)
    List<Book> getBooksWithAuthor(String author);

    @Query(value = "SELECT * FROM BOOKS WHERE language_category = $1", nativeQuery = true)
    List<Book> getBooksWithLanguage(String language);

}
