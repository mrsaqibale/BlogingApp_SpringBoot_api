package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entites.Category;

/**
 * CategoryRepo
 */
public interface CategoryRepo extends JpaRepository<Category, Long> {

}