package com.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entites.User;


public interface UserRepo extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
}
