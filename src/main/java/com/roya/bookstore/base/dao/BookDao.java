package com.roya.bookstore.base.dao;

import com.roya.bookstore.base.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookDao extends JpaRepository<Book, String> {
    Set<Book> findByGenreCategory(String genre);

    Set<Book> findByAuthorCategory(String author);

    Set<Book> findByLanguageCategory(String language);

}
