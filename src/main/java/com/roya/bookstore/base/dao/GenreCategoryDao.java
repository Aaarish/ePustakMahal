package com.roya.bookstore.base.dao;

import com.roya.bookstore.base.entities.categories.GenreCategory;
import com.roya.bookstore.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreCategoryDao extends JpaRepository<GenreCategory, Integer> {
    Optional<GenreCategory> findByCategoryType(CategoryType categoryType);

}
