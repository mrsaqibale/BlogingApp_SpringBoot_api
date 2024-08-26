package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.UserDto;
import com.blog.payloads.ApiResponse;
import com.blog.service.UserServ;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserCont {

    @Autowired
    private UserServ userServ;

    // user login 
    @PostMapping("sign")
    public String login(@RequestBody UserDto userDto){
        return this.userServ.login(userDto);      
    }

    // create user POST
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        System.out.println("the data is " + userDto.getEmail());
        UserDto user = userServ.createUser(userDto);
        return new  ResponseEntity<>(user,HttpStatus.CREATED);
    }

    // update user PUT
    @PutMapping("update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id , @RequestBody UserDto userDto){
        UserDto user = this.userServ.updateUser(userDto, id);
        return ResponseEntity.ok(user);
    }
    
    // delete user DELETE
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId){
        userServ.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted ", true),HttpStatus.OK);
    }


    // get user by id GET
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId){
        return ResponseEntity.ok(userServ.getUserById(userId));
    }

    // get all users
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userServ.getAllUsers());
    }

}
