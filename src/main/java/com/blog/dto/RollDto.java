package com.blog.dto;

import java.util.List;

import com.blog.entites.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RollDto {
    
    private int id;

    private String name;

    private List<User> user;
}
