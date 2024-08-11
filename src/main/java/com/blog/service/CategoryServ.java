package com.blog.service;

import java.util.List;

import com.blog.dto.CategoryDto;

public interface CategoryServ {
    
    // create category
    CategoryDto createCategory(CategoryDto categoryDto);


    // delete category
    void deleteCategory(Long id);


    // update category
    CategoryDto updateCategory(CategoryDto categoryDto , Long id);


    // get category by id
    CategoryDto getCategoryById(Long id);
}
