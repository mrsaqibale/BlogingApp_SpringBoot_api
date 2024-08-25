package com.blog.entites;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User implements UserDetails{

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


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> auth =  this.role.stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return auth;
	}



}
