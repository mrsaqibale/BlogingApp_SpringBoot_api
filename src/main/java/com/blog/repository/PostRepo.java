package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entites.Post;

public interface PostRepo extends JpaRepository<Post, Long>{
    
}
