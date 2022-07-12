package com.leablogs.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 同步执行 getUserById
     *
     * @param id
     * @return
     */
    @CacheResult(cacheKeyMethod = "getUserById")
    @HystrixCommand
    public User getUserById(Long id) {
        return restTemplate.getForObject("", User.class, id);
    }

    @CacheRemove(commandKey = "updateUserById") // 更新时使用清空请求命令缓存
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public User updateUserById(@CacheKey("id") Long id) {
        return restTemplate.getForObject("", User.class, id);
    }

    @HystrixCommand
    public Future<User> getUserByIdAsync(final String id) {

        return new AsyncResult<User>() {
            public User invoke() {
                return restTemplate.getForObject("", User.class, id);
            }
        };
    }
}
