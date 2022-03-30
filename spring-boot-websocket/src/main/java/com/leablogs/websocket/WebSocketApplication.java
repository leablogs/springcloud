package com.leablogs.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
public class WebSocketApplication {
	public static void main(String[] args) throws Exception {
//		System.setProperty("spring.config.name", "app");
		SpringApplication.run(WebSocketApplication.class, args);
	}

}
