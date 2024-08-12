package com.blog.dto;


import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blog.entites.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentDto {

    private Long id;

    @NotNull
    @Size(min = 1, message = "Enter valid comment")
    private String comment;

    private LocalDateTime commentDate;

    private boolean isDeleted = false ;
    

    private User user;
}
