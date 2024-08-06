package com.blog.ServiceImp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.dto.PostDto;
import com.blog.entites.Post;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.repository.PostRepo;
import com.blog.service.PostServ;

public class PostServImp implements PostServ {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepo postRepo;


	@Override
	public PostDto createPost(PostDto postDto) {
		Post post = this.modelMapper.map(postDto, Post.class);
        post.setCreateDate(LocalDateTime.now());
        post.setUpdateDate(LocalDateTime.now());
        Post fpost = this.postRepo.save(post);
		return this.modelMapper.map(fpost, PostDto.class);
	}

	@Override
	public PostDto updatePost(Long id, PostDto postDto) {
		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
        post.setContent(postDto.getContent());
        post.setImage(postDto.getImage());
        post.setTitle(postDto.getTitle());
        post.setUpdateDate(LocalDateTime.now());
        Post fpost = this.postRepo.save(post);

        return this.modelMapper.map(fpost, PostDto.class);
	}

	@Override
	public void deletePost(Long id) {
		Post post = this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
        this.postRepo.delete(post);
	}
    
	@Override
	public PostDto getPostById(Long id) {
        Post post = this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));

        return this.modelMapper.map(post, PostDto.class);
		
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList);
        return postDtos;
		return null;
	}
    
}
