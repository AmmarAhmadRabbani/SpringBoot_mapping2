package com.dailypractice.service;

import java.util.List;

import com.dailypractice.dto.UserDto;

public interface UserService {
	public UserDto add(UserDto userDto);

	public List<UserDto> getAll();

	public UserDto getById(long userId);

	public UserDto update(UserDto userDto);

	public UserDto deleteUserById(long userId);

}
