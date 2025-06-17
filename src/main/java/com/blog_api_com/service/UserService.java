package com.blog_api_com.service;

import com.blog_api_com.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserBtId(Integer userId);
    List<UserDto> getAllUser();
    void deleteUser(Integer userId);

}
