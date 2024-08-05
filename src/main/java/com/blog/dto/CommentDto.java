package com.blog.dto;


import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentDto {

    private Long id;

    
    private String comment;

    private LocalDateTime commentDate;

    private boolean isDeleted = false ;
    

    // private User users;
}
