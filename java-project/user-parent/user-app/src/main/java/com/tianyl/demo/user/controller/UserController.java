package com.tianyl.demo.user.controller;

import java.util.HashMap;
import java.util.List;
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
	public List<User> list() {
		return userService.list();
	}

	@RequestMapping("save")
	@ResponseBody
	public String save() {
		userService.save();
		return "ok";
	}

}
