package com.blog.dto;

import java.time.LocalDateTime;

import com.blog.entites.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Long id;

    private String title;

    private String content;

    private String image;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
    
    
    // private User users;

    private Category categories;
}
