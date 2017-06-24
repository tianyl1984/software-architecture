package com.tianyl.demo.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("server")
public class ServerController {

	@Value("${server.port}")
	private Integer port;

	@Value("${spring.application.name}")
	private String applicationName;

	@RequestMapping("info")
	@ResponseBody
	public Object info() {
		JSONObject json = new JSONObject();
		json.put("name", applicationName);
		json.put("port", port);
		return json;
	}

}
