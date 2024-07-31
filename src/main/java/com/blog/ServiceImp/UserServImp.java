package com.blog.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.dto.UserDto;
import com.blog.entites.User;
import com.blog.repository.UserRepo;
import com.blog.service.UserServ;

public class UserServImp implements UserServ {

	@Autowired
	UserRepo userRepo ;
	
//	modelmapper wired
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		
		return null;
	}

	@Override
	public UserDto getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDto updateUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
