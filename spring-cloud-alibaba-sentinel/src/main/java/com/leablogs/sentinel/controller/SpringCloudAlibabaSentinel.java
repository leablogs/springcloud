package com.leablogs.sentinel.controller;import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.cloud.client.discovery.EnableDiscoveryClient;@SpringBootApplication@EnableDiscoveryClientpublic class SpringCloudAlibabaSentinel {    public static void main(String[] args) {        SpringApplication.run(SpringCloudAlibabaSentinel.class, args);    }}