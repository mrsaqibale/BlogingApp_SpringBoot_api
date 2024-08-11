package com.blog.ServiceImp;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.CategoryDto;
import com.blog.entites.Category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.repository.CategoryRepo;
import com.blog.service.CategoryServ;
@Service
public class CategoryServImp implements CategoryServ {


    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired 
    private ModelMapper modellMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto ) {
        Category category = this.modellMapper.map(categoryDto, Category.class);
        category.setDeleted(false);
        category.setCreateDate(LocalDateTime.now());
        Category category1 = this.categoryRepo.save(category);
        return this.modellMapper.map(category1, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", id));
        category.setDeleted(true);
        this.categoryRepo.save(category);
    }
    
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", id));
        category.setTitle(categoryDto.getTitle());
        Category category2 =  this.categoryRepo.save(category);
        return this.modellMapper.map(category2, CategoryDto.class);
    }
    
    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", id));
        return this.modellMapper.map(category, CategoryDto.class);
    }
    
}
