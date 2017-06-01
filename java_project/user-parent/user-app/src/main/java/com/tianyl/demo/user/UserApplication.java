package com.tianyl.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		// Consul consul =
		// Consul.builder().withUrl("http://192.168.0.122:8500").build();
		// AgentClient agent = consul.agentClient();
		//
		// Registration.RegCheck check =
		// Registration.RegCheck.http("http://192.168.0.104:8080/health", 5);
		// Registration registration =
		// ImmutableRegistration.builder().port(8080).address("192.168.0.104").addChecks(check)
		// .name("user-service").id("user-service-1").build();
		// agent.register(registration);
		// agent.register(8080, "http://192.168.0.104:8080/health", 5, "user-service",
		// "user-service-1", "user");

		// agent.register(8080, 5L, "user-service", "user-service-1", "user");

	}

}
