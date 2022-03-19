package com.leablogs.config;

import java.util.Properties;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
	public ConfigurationCustomizer configurationCustomizer() {
		return new ConfigurationCustomizer() {
			@Bean
			@Override
			public void customize(org.apache.ibatis.session.Configuration configuration) {
				System.out.println("000000000000000000000000000000000000000000000000000");
				MybatisPlus mybatisPlus = new MybatisPlus();
				Properties properties = new Properties();
				properties.setProperty("time", "1");
				mybatisPlus.setProperties(properties);
				configuration.addInterceptor(mybatisPlus);

			}
		};
	}
}
