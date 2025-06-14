package com.blog_api_com.service;

import com.blog_api_com.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    PostDto updatePost(PostDto postDto, Integer postId);
    void deletePost(Integer postId);
    List<PostDto> getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    PostDto getPostBtId(Integer postId);
    List<PostDto> getPostByCategory(Integer categoryId);
    List<PostDto> getPostByUser(Integer userId);
    List<PostDto> searchPosts(String keyword);

}
