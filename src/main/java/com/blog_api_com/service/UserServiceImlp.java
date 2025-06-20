package com.blog_api_com.service;

import com.blog_api_com.payload.UserDto;

import java.util.List;

public interface UserServiceImlp {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUser();
    void deleteUser(Integer userId);

}
