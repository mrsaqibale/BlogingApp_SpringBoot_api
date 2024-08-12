package com.blog.entites;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column()
	private String username;

	@Column()
	private String email;

	@Column()
	private String password;

	@Column()
	private String about;

	@Column()
	private String phNo;

	@Column()
	private String picture;

	@Column()
	private boolean isActive = true;

	@Column()
	private boolean isDeleted = false;
	
	
	@ManyToMany(mappedBy = "user")
	private List<Role> role ;
	

	@OneToMany(mappedBy = "user")
	private List<Comment> comment ;

	
	@OneToMany(mappedBy = "user")
	private List<Post> post;


}
