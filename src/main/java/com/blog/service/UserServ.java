package com.blog.service;

import java.util.List;

import com.blog.dto.UserDto;

public interface UserServ {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    void deleteUser(Long id);

    UserDto updateUser(Long id);

}
