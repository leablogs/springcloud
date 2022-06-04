package com.leablogs;

//import org.springframework.boot.Banner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;


//@EnableEurekaClient
//@SpringBootApplication
//@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//		SpringApplication application = new SpringApplication(Application.class);
//		application.setBannerMode(Banner.Mode.OFF);
//		application.run(args);
		DemoThis demoThis = new DemoThis("333333333333");
		DemoThis demoThis1 = new DemoThis("4444444","bdsf");
	}
}


class DemoThis{
	private final String reader = "sssssssssss";

	DemoThis(String reader) {
		this(reader,"sdfadfesdf");
	}

	DemoThis(String reader, Object o){
		System.out.println(reader + " " + o.toString());
	}
}