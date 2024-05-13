package com.roya.bookstore.base.entities;

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
    @Column(name = "book_id", unique = true, nullable = false)
    private String bookId;
    private String title;
    private String author;
    private int pages;
    private String description;

    @Column(name = "is_in_stock")
    private boolean isInStock;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    private String genreCategory;
    private String authorCategory;
    private String languageCategory;

}
