package com.blog_api_com.service.impl;

import com.blog_api_com.payload.CommentDto;

public interface CommentServiceImpl {

    public CommentDto createComment(CommentDto commentDto, Integer postId);
    public void deleteComment(Integer commentId);


}
