package com.blog_api_com.service.impl;

import com.blog_api_com.dao.CommentRepo;
import com.blog_api_com.dao.PostRepo;
import com.blog_api_com.entity.Comment;
import com.blog_api_com.entity.Post;
import com.blog_api_com.exception.ResourceNotFoundException;
import com.blog_api_com.payload.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService implements CommentServiceImpl{

    @Autowired private PostRepo postRepo;
    @Autowired private CommentRepo commentRepo;
    @Autowired private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = commentRepo.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment", "comment Id", commentId));
        commentRepo.delete(comment);
    }

}
