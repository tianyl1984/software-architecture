package com.tianyl.demo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tianyl.demo.userClient.service.IUserService;

@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OrderApplication.class, args);
		IUserService userService = context.getBean(IUserService.class);
		System.out.println(userService.getUser(1L));
	}

}
