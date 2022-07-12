package com.leablogs;

import com.netflix.discovery.endpoint.EndpointUtils;
import com.netflix.discovery.shared.LookupService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerApplication {

	public static void main(String[] args) throws Exception {
//		EurekaDiscoveryClient
//		LookupService
//		EndpointUtils
//		EurekaInstanceConfigBean
		SpringApplication.run(ServerApplication.class, args);
	}

}