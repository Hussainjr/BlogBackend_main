package com.blog_api_com.dao;

import com.blog_api_com.entity.Category;
import com.blog_api_com.entity.Post;
import com.blog_api_com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByTitleContaining(String title);

}
