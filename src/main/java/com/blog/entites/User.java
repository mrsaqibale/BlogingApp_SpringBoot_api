package com.blog.entites;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = true, nullable = false)
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


}
