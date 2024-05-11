package com.roya.bookstore.base.entities;

import com.roya.bookstore.base.entities.categories.AuthorCategory;
import com.roya.bookstore.base.entities.categories.GenreCategory;
import com.roya.bookstore.base.entities.categories.LanguageCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    private String bookId;
    private String title;
    private String author;
    private int pages;
    private String description;
    private boolean isInStock;
    private int quantityInStock;

    @ManyToOne
    @JoinColumn(name = "genre_category", referencedColumnName = "categoryId")
    private GenreCategory genreCategory;
    @ManyToOne
    @JoinColumn(name = "author_category", referencedColumnName = "categoryId")
    private AuthorCategory authorCategory;
    @ManyToOne
    @JoinColumn(name = "language_category", referencedColumnName = "categoryId")
    private LanguageCategory languageCategory;

}
