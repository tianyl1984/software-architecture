package com.tianyl.demo.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyl.demo.user.entity.User;
import com.tianyl.demo.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("list")
	@ResponseBody
	public Object list() {
		return userService.list();
	}

	@RequestMapping("save")
	@ResponseBody
	public Object save(Integer userId, @RequestParam(name = "users", required = false) User[] users) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("users", users);
		return map;
	}

}
