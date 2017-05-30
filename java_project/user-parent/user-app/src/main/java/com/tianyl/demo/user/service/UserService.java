package com.tianyl.demo.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyl.demo.user.entity.User;
import com.tianyl.demo.user.mapper.UserMapper;
import com.tianyl.demo.userClient.dto.UserDto;
import com.tianyl.demo.userClient.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserMapper userMapper;

	public List<User> list() {
		return userMapper.selectAll();
	}

	@Override
	public UserDto getUser(Long userId) {
		UserDto user = new UserDto();
		user.setId(123L);
		user.setEmail("zhangsan@123.com");
		return user;
	}

}
