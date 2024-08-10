package com.blog.service;

import com.blog.dto.PostDto;
import java.util.List;

public interface PostServ {
    PostDto createPost(PostDto postDto);

    PostDto updatePost(Long id, PostDto postDto);

    void deletePost(Long id);

    PostDto getPostById(Long id );

    List<PostDto> getAllPosts();

    List<PostDto> getPostByCategory(Long id);

    List<PostDto> getPostByUser(Long id);

    List<PostDto> searchPostByString(String key);
}
