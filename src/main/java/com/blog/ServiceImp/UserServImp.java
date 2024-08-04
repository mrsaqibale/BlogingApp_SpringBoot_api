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
import com.blog.exceptions.ResourceNotFoundException;;
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
		System.out.println(user.getEmail());
		return this.modelMapper.map(user1, UserDto.class);
	}

	@Override
	public UserDto getUserById(Long id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User ", " id ", id));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// 
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User ", " id ", id));
		this.userRepo.delete(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto,Long id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User ", " id " , id));
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());

		return null;
	}

}
