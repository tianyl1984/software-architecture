package com.tianyl.demo.user.conf;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class WebServerConfig {

	@Bean
	public EmbeddedServletContainerCustomizer customizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
				ErrorPage page403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403.html");
				ErrorPage page500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error.html");
				container.addErrorPages(page404, page403, page500);
			}
		};
	}

}
