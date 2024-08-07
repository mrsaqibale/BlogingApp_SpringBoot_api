package com.blog.dto;

import java.sql.Date;
import java.util.List;

import com.blog.entites.Post;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

public class CategoryDto {

    private Long id;

    private String title;

    private Date assignDate;

    private boolean isDeleted = false;

    // private List<Post> posts ;
}
