package com.leablogs.config;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @description
 * @author: shilh
 * @time 2022/7/29 20:37
 */
@Component
public class ThreadConfig {
    public Executor getAsyncExcutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(16);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("mysql-serice-");
        executor.initialize();
        return executor;
    }
}





































