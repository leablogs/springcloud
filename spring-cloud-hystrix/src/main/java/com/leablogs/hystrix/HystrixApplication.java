package com.leablogs.hystrix;

import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard // hystrix 监控
//@EnableTurbine
public class HystrixApplication {
    public static void main(String[] args) {
//        HystrixCommands
//        HystrixObservableCommand
        SpringApplication.run(HystrixApplication.class,args);
    }
}
