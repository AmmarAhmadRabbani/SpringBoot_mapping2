package com.dailypractice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailypractice.dto.UserDto;
import com.dailypractice.dto.UserInfoDto;
import com.dailypractice.entity.User;
import com.dailypractice.entity.UserInfo;
import com.dailypractice.exception.UserNotFoundException;
import com.dailypractice.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDto add(UserDto userDto) {
		if (userDto != null) {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);
			UserInfoDto userInfoDto = userDto.getUserInfo();
			UserInfo userInfos = new UserInfo();
			BeanUtils.copyProperties(userInfoDto, userInfos);
			user.setUserInfo(userInfos);
			userInfos.setUser(user);

			User save = repository.save(user);

			BeanUtils.copyProperties(save, userDto);
			return userDto;
		}
		throw new UserNotFoundException("something went wrong");
	}

	@Override
	public List<UserDto> getAll() {

		List<User> findAll = repository.findAll();
		List<UserDto> listDto = new ArrayList<>();
		if (!findAll.isEmpty()) {
			findAll.forEach(i -> {
				UserDto userDto = new UserDto();
				BeanUtils.copyProperties(i, userDto);
				UserInfo userInfo = i.getUserInfo();
				UserInfoDto userInfoDto = new UserInfoDto();
				BeanUtils.copyProperties(userInfo, userInfoDto);
				userDto.setUserInfo(userInfoDto);
				listDto.add(userDto);
			});
			return listDto;
		}

		throw new UserNotFoundException("data is not present:");

	}

	@Override
	public UserDto getById(long userId) {
		User orElseThrow = repository.findById(userId).orElseThrow(() -> new UserNotFoundException("id not present"));

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(orElseThrow, userDto);
		UserInfoDto dto = new UserInfoDto();
		UserInfo userInfo = orElseThrow.getUserInfo();
		BeanUtils.copyProperties(userInfo, dto);

		userDto.setUserInfo(dto);

		return userDto;
	}

	@Override
	public UserDto update(UserDto userDto) {
		User orElseThrow = repository.findById(userDto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("invalid id"));
		BeanUtils.copyProperties(userDto, orElseThrow);
		UserInfoDto userInfo = userDto.getUserInfo();
		UserInfo info = new UserInfo();
		BeanUtils.copyProperties(userInfo, info);
		orElseThrow.setUserInfo(info);
		info.setUser(orElseThrow);
		repository.save(orElseThrow);
		BeanUtils.copyProperties(orElseThrow, userDto);
		return userDto;
	}

	@Override
	public UserDto deleteUserById(long userId) {
		User orElseThrow = repository.findById(userId).orElseThrow(() -> new UserNotFoundException("id not present"));
		repository.deleteById(userId);
		return new UserDto();
	}

}
 