package com.blog.service;

import java.util.List;

import com.blog.dto.CommentDto;

public interface CommentServ {

    CommentDto createComment(CommentDto commentDto);

    
    CommentDto updateComment(CommentDto commentDto);
    

    void deleteComment(Long id );


    List<CommentDto> getAllComments();


    CommentDto getCommentById(Long id);

}
