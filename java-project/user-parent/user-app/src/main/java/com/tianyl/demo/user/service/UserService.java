package com.tianyl.demo.user.service;

import java.util.List;

import com.tianyl.demo.common.util.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyl.demo.user.entity.User;
import com.tianyl.demo.user.mapper.UserMapper;
import com.tianyl.demo.userClient.dto.UserDto;
import com.tianyl.demo.userClient.service.IUserService;

@Service
public class UserService implements IUserService{

	private Logger logger = LoggerFactory.getLogger(getClass());

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

	public void save() {
		User user = new User();
		user.setEmail(DataUtil.getRandomStr() + "@123.com");
		user.setPassword(DataUtil.getRandomStr());
		user.setUsername(DataUtil.getRandomStr());
		userMapper.insert(user);
		logger.info("save-user:" + user.getId());
	}

}
