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
	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = false, nullable = false)
	private String email;

	@Column( nullable = false)
	private String password;

	@Column()
	private String about;

	@Column()
	private String phNo;

	@Column()
	private String picture;

	@Column( nullable = false)
	private boolean isActive = true;

	@Column( nullable = false)
	private boolean isDeleted = false;
	
	
	@ManyToMany(mappedBy = "users")
	private List<Role> roles ;
	

	@OneToMany(mappedBy = "users")
	private List<Comment> comments ;

	
	@OneToMany(mappedBy = "users")
	private List<Post> posts ;


}
