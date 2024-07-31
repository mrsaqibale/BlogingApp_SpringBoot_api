package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.UserDto;
import com.blog.service.UserServ;

@RestController
@RequestMapping("/api/users")
public class UserCont {

    @Autowired
    private UserServ userServ;

    // create user POST
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(UserDto userDto){
        UserDto user = userServ.createUser(userDto);
        return new  ResponseEntity<>(user,HttpStatus.CREATED);
    }

    // update user PUT

    // delete user DELETE

    // get user by id GET
    
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId){
        return ResponseEntity.ok(userServ.getUserById(userId));
    }

}
