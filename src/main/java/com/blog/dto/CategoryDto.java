package com.blog.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.blog.entites.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Long id;

    private String title;

    private LocalDateTime createDate;

    private boolean isDeleted;

    // private List<Post> post ;
}
