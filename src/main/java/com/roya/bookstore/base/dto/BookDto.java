package com.roya.bookstore.base.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {
    private String bookId;
    private String title;
    private String author;
    private int pages;
    private String description;

    @JsonProperty("is_in_stock")
    private boolean isInStock;
    @JsonProperty("quantity_in_stock")
    private int quantityInStock;
    @JsonProperty("genre_category")
    private String genreCategory;
    @JsonProperty("author_category")
    private String authorCategory;
    @JsonProperty("language_category")
    private String languageCategory;

}
