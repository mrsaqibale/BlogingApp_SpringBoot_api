package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entites.Category;
import com.blog.entites.Post;

public interface PostRepo extends JpaRepository<Post, Long>{

    List<Post> findByCategory(Category category);

}
