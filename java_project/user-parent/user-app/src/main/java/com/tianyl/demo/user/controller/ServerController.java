package com.tianyl.demo.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyl.demo.user.entity.User;

@Controller
@RequestMapping("server")
public class ServerController {

	@Value("${server.port}")
	private Integer port;

	@RequestMapping("info")
	@ResponseBody
	public Object info() {
		User u = new User();
		u.setId(1L);
		u.setUsername("sadf");
		return u;
		// return "server:" + port;
	}

}
