package com.tianyl.demo.order.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.tianyl.demo.userClient.service.IUserService;

@Configuration
public class UserHttpInvokerProxy {

	@Bean
	public IUserService createUserService() {
		HttpInvokerProxyFactoryBean factory = new HttpInvokerProxyFactoryBean();
		factory.setServiceUrl("http://127.0.0.1:8080/userRemoteService");
		factory.setServiceInterface(IUserService.class);
		factory.afterPropertiesSet();
		return (IUserService) factory.getObject();
	}

}
