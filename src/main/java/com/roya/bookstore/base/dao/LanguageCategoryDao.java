package com.roya.bookstore.base.dao;

import com.roya.bookstore.base.entities.categories.LanguageCategory;
import com.roya.bookstore.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageCategoryDao extends JpaRepository<LanguageCategory, Integer> {
    Optional<LanguageCategory> findByCategoryType(CategoryType categoryType);

}
