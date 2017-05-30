package com.tianyl.demo.user.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.tianyl.demo.user.service.UserService;

@Configuration
public class HttpInvokerService {

	@Bean(name = "/userRemoteService")
	public HttpInvokerServiceExporter createUserService(UserService userService) {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(userService);
		exporter.setServiceInterface(userService.getClass().getInterfaces()[0]);
		return exporter;
	}

}
