package com.blog.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserDto {

	private Long id;

	private String username;

	private String email;

	private String password;

	private String about;

	private String phNo;

	private String picture;

	private boolean isActive ;
	
	private boolean isDeleted ;

	
	// private List<Role> roles ;
	
	// private List<Comment> comments ;

	// private List<Post> posts ;
}
