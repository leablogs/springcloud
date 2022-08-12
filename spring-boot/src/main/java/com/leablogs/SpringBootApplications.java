package com.leablogs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(value = "com.leablogs.user.mapper")
public class SpringBootApplications {
    public static void main(String[] args) {
//        System.setProperty("spring.config.name", "application"); // 设置指定加载的配置文件
//        SpringApplication application = new SpringApplication(SpringBootApplications.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);
        // 等同与以上三行
        SpringApplication.run(SpringBootApplications.class, args);
    }
}