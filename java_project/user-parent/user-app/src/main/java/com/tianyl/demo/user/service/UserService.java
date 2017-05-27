package com.tianyl.demo.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyl.demo.user.entity.User;
import com.tianyl.demo.user.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> list() {
		return userMapper.selectAll();
	}

}
