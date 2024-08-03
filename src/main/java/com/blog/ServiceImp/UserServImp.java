package com.blog.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.UserDto;
import com.blog.entites.User;
import com.blog.repository.UserRepo;
import com.blog.service.UserServ;

@Service
public class UserServImp implements UserServ {

	@Autowired
	private UserRepo userRepo ;
	
	@Autowired
	private ModelMapper modelMapper ;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User user1 = this.userRepo.save(user);
		return this.modelMapper.map(user1, UserDto.class);
	}

	@Override
	public UserDto getUserById(Long id) {
		Optional<User> user = this.userRepo.findById(id);
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// 
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// delete user by id
		this.userRepo.deleteById(id);
	}

	@Override
	public UserDto updateUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
