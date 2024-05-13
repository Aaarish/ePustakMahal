package com.roya.bookstore.enums;

import lombok.Getter;

@Getter
public enum CategoryType {
    LANGUAGE(1, "language"),
    AUTHOR(2, "author"),
    GENRE(3, "genre");

    private final int categoryCode;
    private final String category;

    CategoryType(int categoryCode, String category) {
        this.categoryCode = categoryCode;
        this.category = category;
    }
}
