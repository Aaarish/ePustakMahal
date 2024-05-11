package com.roya.bookstore.base.dao;

import com.roya.bookstore.base.entities.categories.AuthorCategory;
import com.roya.bookstore.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorCategoryDao extends JpaRepository<AuthorCategory, Integer> {
    Optional<AuthorCategory> findByCategoryType(CategoryType categoryType);

}
