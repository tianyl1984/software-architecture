package com.tianyl.demo.order;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.tianyl.demo.userClient.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.orbitz.consul.Consul;
import com.orbitz.consul.cache.ConsulCache;
import com.orbitz.consul.cache.ServiceHealthCache;
import com.orbitz.consul.cache.ServiceHealthKey;
import com.orbitz.consul.model.health.ServiceHealth;
import com.orbitz.consul.option.QueryOptions;

@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderApplication.class, args);
//		 IUserService userService = context.getBean(IUserService.class);
//		 System.out.println(userService.getUser(1L));

		// Consul consul =
		// Consul.builder().withUrl("http://192.168.0.122:8500").build();
		// HealthClient healthClient = consul.healthClient();
		// List<ServiceHealth> services =
		// healthClient.getHealthyServiceInstances("user-service").getResponse();
		// for (ServiceHealth service : services) {
		// Service ser = service.getService();
		// System.out.println(ser.getAddress() + ":" + ser.getPort());
		// System.out.println(ser.getId());
		// System.out.println(ser.getTags());
		// }
//		System.out.println("over");
//
//		ServiceHealthCache serviceHealthCache = ServiceHealthCache.newCache(
//				Consul.builder().withUrl("http://192.168.0.122:8500").build().healthClient(), "user-service", true, 15,
//				QueryOptions.BLANK);
//		serviceHealthCache.addListener(new ConsulCache.Listener<ServiceHealthKey, ServiceHealth>() {
//			@Override
//			public void notify(Map<ServiceHealthKey, ServiceHealth> newValues) {
//				System.out.println("状态通知-----start");
//				for (ServiceHealthKey healthKey : newValues.keySet()) {
//					System.out.println(healthKey.toString());
//					System.out.println(newValues.get(healthKey).getService().toString());
//				}
//				System.out.println("状态通知-------end");
//			}
//		});
//		serviceHealthCache.awaitInitialized(5, TimeUnit.SECONDS);
		// serviceHealthCache.newCache(healthClient, serviceName, passing, watchSeconds,
		// queryOptions, keyExtractor)
//		serviceHealthCache.start();
	}

}
