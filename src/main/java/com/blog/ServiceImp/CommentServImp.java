package com.blog.ServiceImp;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.CommentDto;
import com.blog.entites.Comment;
import com.blog.repository.CommentRepo;
import com.blog.service.CommentServ;

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
	public CommentDto updateComment(CommentDto commentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CommentDto> getAllComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDto getCommentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
