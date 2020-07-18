package org.tianyl.starter.mybatis;

import java.util.Properties;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

public class MybatisApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		Environment env = applicationContext.getEnvironment();
		String pkg = env.getProperty("spring.mybatis.pkg");
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage(pkg);
		configurer.setMarkerInterface(Mapper.class);
		Properties properties = new Properties();
		properties.setProperty("mappers", Mapper.class.getName());
		properties.setProperty("style", "normal");
//		configurer.setProperties(properties);
		configurer.setApplicationContext(applicationContext);
		applicationContext.addBeanFactoryPostProcessor(configurer);
	}

}
