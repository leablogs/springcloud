package com.leablogs.test;

import java.lang.reflect.Proxy;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.scope.ScopedProxyFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.leablogs.test.config.AppConfig;
import com.leablogs.test.interceptor.MyInterceptor;
import com.leablogs.test.interceptor.ProxyBean;
import com.leablogs.test.service.HelloService;
import com.leablogs.test.service.impl.HelloServiceImpl;

@SpringBootApplication()
public class SpringBootTest {
	public static void main(String[] args) throws Exception {
//		SpringBootTest.testProxy();
		SpringApplication.run(SpringBootTest.class, args);
	}

	public static void testProxy() {
		HelloService helloService = new HelloServiceImpl();
		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
		proxy.sayHello("zhangsan");
		System.out.println("####################");
		proxy.sayHello(null);
	}
}
