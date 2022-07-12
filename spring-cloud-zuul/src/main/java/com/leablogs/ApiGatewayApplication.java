package com.leablogs;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.leablogs.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {
	public static void main(String[] args) throws Exception {
		System.out.println("=========");
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public AccessFilter accessFilter() {
		System.out.println("access filter");
		return new AccessFilter();
	}
}
