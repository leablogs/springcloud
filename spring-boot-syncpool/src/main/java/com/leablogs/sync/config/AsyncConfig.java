package com.leablogs.sync.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configurable
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(10);
		taskExecutor.setMaxPoolSize(20);
		taskExecutor.setQueueCapacity(2000);
		taskExecutor.initialize();
		return taskExecutor;
	}
}
