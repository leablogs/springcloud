package com.leablogs;

import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.MDC;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.UUID;

@SpringBootApplication
@EnableScheduling
@MapperScan(value = "com.leablogs.user.mapper")
@Log4j
public class SpringBootApplications {
    public static void main(String[] args) {
        log.info("22222222222222222222");
        MDC.put("traceId", UUID.randomUUID().toString());
        System.setProperty("spring.config.name", "application"); // 设置指定加载的配置文件
        SpringApplication application = new SpringApplication(SpringBootApplications.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        // 等同与以上三行
        // SpringApplication.run(SpringBootApplications.class, args);
    }
}