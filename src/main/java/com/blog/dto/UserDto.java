package com.blog.dto;

import java.util.List;

import com.blog.entites.Comment;
import com.blog.entites.Post;
import com.blog.entites.Role;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

	// private boolean isActive ;

	// private boolean isDeleted ;

	
	// private List<Role> roles ;
	
	// private List<Comment> comments ;

	// private List<Post> posts ;
}
