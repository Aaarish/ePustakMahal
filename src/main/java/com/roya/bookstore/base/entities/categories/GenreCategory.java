package com.roya.bookstore.base.entities.categories;

import com.roya.bookstore.base.entities.Book;
import com.roya.bookstore.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.roya.bookstore.enums.CategoryType.GENRE;

@Entity
@Table(name = "genre_category")
@Getter
@Setter
public class GenreCategory {
    @Id
    private int categoryId;
    private CategoryType categoryType;

    @OneToMany(mappedBy = "genreCategory", fetch = FetchType.EAGER)
    private List<Book> books;

    public CategoryType getCategoryType() {
        this.categoryType = GENRE;
        return this.categoryType;
    }

}
