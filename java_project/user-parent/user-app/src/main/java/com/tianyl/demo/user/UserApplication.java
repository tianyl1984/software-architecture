package com.tianyl.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tianyl.demo.common.util.ThreadUtil;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class, args);
//		ThreadUtil.safeSleep();
		// context.close();
	}

}
