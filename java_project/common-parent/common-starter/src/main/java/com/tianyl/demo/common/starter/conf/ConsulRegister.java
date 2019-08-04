package com.tianyl.demo.common.starter.conf;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.NotRegisteredException;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration.RegCheck;
import com.tianyl.demo.common.util.ThreadUtil;

//@Component
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
		String address = getAddress(consulServer);
		serviceId = createServiceId(agent, address, port);
		ImmutableRegistration.Builder builder = ImmutableRegistration.builder();
		builder.id(serviceId).name(serviceName).check(RegCheck.ttl(15L)).port(port).address(address);
		agent.register(builder.build());
		new Thread(new TTLCheckTask(agent, serviceId)).start();
	}

	private String getAddress(String consulServer) {
		try {
			URI uri = new URI(consulServer);
			String host = uri.getHost();
			int port = uri.getPort();
			Socket s = new Socket(host, port);
			String result = s.getLocalAddress().getHostName();
			s.close();
			return result;
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private String createServiceId(AgentClient agent, String address, int port) {
		return serviceName + "-" + address + ":" + port;
	}

	@PreDestroy
	public void unRegister() {
		logger.info("start unregister to consul,consul.server:{},service:{},port:{}", consulServer, serviceName, port);
		agent.deregister(serviceId);
		consul.destroy();
	}

	private static class TTLCheckTask implements Runnable {

		private AgentClient agent;

		private String serviceId;

		public TTLCheckTask(AgentClient agent, String serviceId) {
			this.agent = agent;
			this.serviceId = serviceId;
		}

		@Override
		public void run() {
			while (true) {
				try {
					agent.pass(serviceId);
				} catch (NotRegisteredException e) {
					e.printStackTrace();
					break;
				}
				ThreadUtil.safeSleep(10);
			}
		}

	}
}
