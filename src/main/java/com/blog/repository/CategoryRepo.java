package com.blog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entites.Category;

/**
 * CategoryRepo
 */
public interface CategoryRepo extends JpaRepository<Category, Long> {
    //  get all the post of category
    public List<Category> findByCategory(String category);
}