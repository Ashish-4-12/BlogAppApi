package com.backendprojects.blog.services;

import java.util.List;

import com.backendprojects.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer Id);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
 