package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.ServiceImp.PostServImp;
import com.blog.dto.PostDto;

@RestController
@RequestMapping("/api/posts")
public class PostCont {
    

    @Autowired
    private PostServImp postServImp;

    // create post
    public ResponseEntity<PostDto> createPost(PostDto postDto){
        PostDto post = this.postServImp.createPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    // update post

    // delete post

    // get post by id 

    // get all posts
}
