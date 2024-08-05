package com.blog.dto;


import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentDto {

    private Long id;

    @NotEmpty
    @Size(min = 1 , message = "Comment is not Valid")
    private String comment;

    private LocalDateTime commentDate;

    private boolean isDeleted = false ;
    

    // private User users;
}
