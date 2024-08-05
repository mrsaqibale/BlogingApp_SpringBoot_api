package com.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.CommentDto;
import com.blog.payloads.ApiResponse;
import com.blog.service.CommentServ;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/comments")
public class CommentCont {

    @Autowired
    private CommentServ commentServ;
    

    // create comment
    @PostMapping("/")
    public ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentServ.createComment(commentDto));
    }


    // update comment 
    @PutMapping("update/{id}")
    public ResponseEntity<CommentDto> updateComment(@Valid  @RequestBody CommentDto commentDto , @PathVariable Long id) {
        try {
            return ResponseEntity.ok(commentServ.updateComment(commentDto, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // delete comment
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Long id){
        this.commentServ.deleteComment(id);
        return ResponseEntity.ok(new ApiResponse("Comment deleted successfully", true));
    }

    // get comment by id 
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getMethodName(@PathVariable Long commentId) {
        return ResponseEntity.ok(commentServ.getCommentById(commentId));
    }

    // get all the comments 
    @GetMapping("/")
    public ResponseEntity<List<CommentDto>> getAllComments(){
        return ResponseEntity.ok(this.commentServ.getAllComments());
    }
    
}


