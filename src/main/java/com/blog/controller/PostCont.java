package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.PostDto;
import com.blog.payloads.ApiResponse;
import com.blog.service.PostServ;

@RestController
@RequestMapping("/api/posts")
public class PostCont {
    

    @Autowired
    private PostServ postServ;

    // create post
    @PostMapping("/")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto post = this.postServ.createPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    // update post
    @PutMapping("update/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto , @PathVariable Long id ){
        PostDto post = this.postServ.updatePost(id, postDto);
        return ResponseEntity.ok(post);
    }
    
    
    // delete post
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Long id){
        this.postServ.deletePost(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted ", true), HttpStatus.OK);
    }


    // get post by id 
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id){
        PostDto postDto = this.postServ.getPostById(id);
        return ResponseEntity.ok(postDto);
    }
    

    // get all posts
    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> postDto = this.postServ.getAllPosts();
        return ResponseEntity.ok(postDto);
    }


    // custom methods
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Long id){
        List<PostDto> postDto = this.postServ.getPostByCategory(id);
        return ResponseEntity.ok(postDto);
        }
}
