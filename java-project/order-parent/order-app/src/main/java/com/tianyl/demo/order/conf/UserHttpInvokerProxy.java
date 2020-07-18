package com.tianyl.demo.order.conf;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpComponentsHttpInvokerRequestExecutor;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.tianyl.demo.userClient.service.IUserService;
import org.springframework.remoting.httpinvoker.HttpInvokerRequestExecutor;

@Configuration
public class UserHttpInvokerProxy {

	@Bean
	public IUserService createUserService() {
		HttpInvokerProxyFactoryBean factory = new HttpInvokerProxyFactoryBean();
		factory.setServiceUrl("http://127.0.0.1:8080/userRemoteService");
		factory.setServiceInterface(IUserService.class);
		factory.setHttpInvokerRequestExecutor(getHttpClientInvoker());
		factory.afterPropertiesSet();
		return (IUserService) factory.getObject();
	}

	private HttpInvokerRequestExecutor getHttpClientInvoker() {
		return new HttpComponentsHttpInvokerRequestExecutor(httpClient());
	}

	private HttpClient httpClient() {
		return HttpClients.custom()
				.setDefaultRequestConfig(requestConfig())
				.setConnectionManager(connectionManager())
				.setRedirectStrategy(new LaxRedirectStrategy())
				.build();
	}

	private RequestConfig requestConfig() {
		int oneMinute = 60 * 1000;
		return RequestConfig.custom()
				.setConnectTimeout(oneMinute)
				.build();
	}

	private HttpClientConnectionManager connectionManager() {
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(100);
		connectionManager.setDefaultMaxPerRoute(5);
		return connectionManager;
	}
}
