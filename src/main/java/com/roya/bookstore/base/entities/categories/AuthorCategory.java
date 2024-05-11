package com.roya.bookstore.base.entities.categories;

import com.roya.bookstore.base.entities.Book;
import com.roya.bookstore.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.roya.bookstore.enums.CategoryType.AUTHOR;

@Entity
@Table(name = "author_category")
@Getter
@Setter
public class AuthorCategory {
    @Id
    private int categoryId;
    private CategoryType categoryType;

    @OneToMany(mappedBy = "authorCategory", fetch = FetchType.EAGER)
    private List<Book> books;

    public CategoryType getCategoryType() {
        this.categoryType = AUTHOR;
        return this.categoryType;
    }

}
