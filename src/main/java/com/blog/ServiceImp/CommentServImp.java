package com.blog.ServiceImp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.CommentDto;
import com.blog.dto.PostDto;
import com.blog.dto.UserDto;
import com.blog.entites.Comment;
import com.blog.repository.CommentRepo;
import com.blog.service.CommentServ;
import com.blog.exceptions.ResourceNotFoundException;
@Service
public class CommentServImp implements  CommentServ{


	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CommentRepo commentRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto) {
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setCommentDate(LocalDateTime.now());
		comment.setDeleted(false);
		Comment comment1 = this.commentRepo.save(comment);	
		return this.modelMapper.map(comment1, CommentDto.class);
	}

	@Override
	public CommentDto updateComment(CommentDto commentDto, Long id) {
		Comment comment = this.commentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Comment", "Id", id));
		comment.setComment(commentDto.getComment());
		Comment fComment = this.commentRepo.save(comment);
		return this.modelMapper.map(fComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Long id) {
		Comment comment = this.commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "ID", id));
		comment.setDeleted(true);
		this.commentRepo.save(comment);
	}

	@Override
	public List<CommentDto> getAllComments() {
		List<Comment> comments = this.commentRepo.findAll();
		List<CommentDto> commentDtos = comments.stream().map((comment) -> this.modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
		return commentDtos;
	}

	@Override
	public CommentDto getCommentById(Long id) {
		Comment comment = this.commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment ", " id ", id));
		return this.modelMapper.map(comment, CommentDto.class);
	}

}
