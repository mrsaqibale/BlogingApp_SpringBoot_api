package com.blog.ServiceImp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.PostDto;
import com.blog.entites.Category;
import com.blog.entites.Post;
import com.blog.entites.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.repository.CategoryRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.UserRepo;
import com.blog.service.PostServ;

import jakarta.annotation.Resource;

@Service
public class PostServImp implements PostServ {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepo postRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private UserRepo userRepo;


	@Override
	public PostDto createPost(PostDto postDto, Long userId, Long categoryId) {

		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
        post.setCreateDate(LocalDateTime.now());
        post.setUpdateDate(LocalDateTime.now());
		post.setCategory(category);
		post.setUser(user);
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
    
	// get post by id
	@Override
	public PostDto getPostById(Long id) {
        Post post = this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
        return this.modelMapper.map(post, PostDto.class);
		
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
	}


	// custom methods 
    public List<PostDto> getPostByCategory(Long id){
		Category category = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
		System.out.println(category);
		List<Post> posts= this.postRepo.findByCategory(category);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

    public List<PostDto> getPostByUser(Long id){
		return null;
	}

    public List<PostDto> searchPostByString(String key){
		return null;
	}
    
}
