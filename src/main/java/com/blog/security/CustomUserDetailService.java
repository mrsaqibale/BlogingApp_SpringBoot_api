package com.blog.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.entites.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= this.userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", username));
        System.out.println(user.getUsername()+"    " + user.getPassword());
        return user;
    }

    
}
