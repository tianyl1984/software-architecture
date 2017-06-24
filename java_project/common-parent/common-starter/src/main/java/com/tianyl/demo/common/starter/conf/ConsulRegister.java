package com.tianyl.demo.common.starter.conf;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;

@Component
public class ConsulRegister {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${consul.server}")
	private String consulServer;

	@Value("${spring.application.name}")
	private String serviceName;

	@Value("${server.port}")
	private int port;

	private Consul consul;

	private AgentClient agent;

	private String serviceId;

	@PostConstruct
	public void register() {
		logger.info("start register to consul,consul.server:{},service:{},port:{}", consulServer, serviceName, port);
		consul = Consul.builder().withUrl(consulServer).build();
		agent = consul.agentClient();
		serviceId = createServiceId(agent);
		agent.register(port, 5L, serviceName, serviceId);
	}

	private String createServiceId(AgentClient agent) {
		return serviceName + "-" + UUID.randomUUID().toString();
	}

	@PreDestroy
	public void unRegister() {
		logger.info("start unregister to consul,consul.server:{},service:{},port:{}", consulServer, serviceName, port);
		agent.deregister(serviceId);
		consul.destroy();
	}

}
