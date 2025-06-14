package com.blog_api_com.service.impl;

import com.blog_api_com.dao.CategoryRepo;
import com.blog_api_com.dao.PostRepo;
import com.blog_api_com.dao.UserRepo;
import com.blog_api_com.entity.Category;
import com.blog_api_com.entity.Post;
import com.blog_api_com.entity.User;
import com.blog_api_com.exception.ResourceNotFoundException;
import com.blog_api_com.payload.PostDto;
import com.blog_api_com.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "categoryId", categoryId));

        Post post = postDtoToEntity(postDto);
        return null;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        return List.of();
    }

    @Override
    public PostDto getPostBtId(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }
}
