package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entites.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
