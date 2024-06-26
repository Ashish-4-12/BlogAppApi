package com.backendprojects.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backendprojects.blog.entities.User;
import com.backendprojects.blog.exceptions.ResourceNotFoundException;
import com.backendprojects.blog.payloads.UserDto;
import com.backendprojects.blog.repositories.UserRepo;
import com.backendprojects.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.UserToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		User updatedUser = this.userRepo.save(user);

		return this.UserToDto(updatedUser);

	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();

		List<UserDto> userDtos = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		this.userRepo.delete(user);
	}

	// Mapper
	private User dtoToUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);

		// User user = new User();
		// user.setName(userDto.getName());
		// user.setEmail(userDto.getEmail());
		// user.setAbout(userDto.getAbout());
		// user.setId(userDto.getId());
		// user.setPassword(userDto.getPassword());

		return user;
	}

	// Mapper
	private UserDto UserToDto(User user) {

		UserDto userDto = this.modelMapper.map(user, UserDto.class);

		// UserDto userDto = new UserDto();
		// userDto.setName(user.getName());
		// userDto.setEmail(user.getEmail());
		// userDto.setAbout(user.getAbout());
		// userDto.setId(user.getId());
		// userDto.setPassword(user.getPassword());

		return userDto;
	}
}
