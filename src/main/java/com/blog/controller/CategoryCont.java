package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.CategoryDto;
import com.blog.payloads.ApiResponse;
import com.blog.service.CategoryServ;

@RestController
@RequestMapping("/api")
public class CategoryCont {
    
    @Autowired
    private CategoryServ categoryServ;

    // create 
    @PostMapping("category/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto category = categoryServ.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    // update
    @PutMapping("category/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Long id){
        CategoryDto category = this.categoryServ.updateCategory(categoryDto, id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    // delete
    @DeleteMapping("cat/")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id){
        this.categoryServ.deleteCategory(id);
        return new ResponseEntity<>(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
    }


    // by id 
    @GetMapping("category/{id}")
    public ResponseEntity<CategoryDto> getById(Long id){
        CategoryDto category = this.categoryServ.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
