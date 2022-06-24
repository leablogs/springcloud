package com.leablogs.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

public class UserObservableService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 同步执行 getUserById
     *
     * @param id
     * @return
     */
    /** EAGER 参数模式, LAZY toBservable()执行模式
     * @return**/
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.EAGER)
    public Observable<User> getUserById(Long id) {
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        User user = restTemplate.getForObject("", User.class, id);
                        observer.onNext(user);
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        });
    }

    @HystrixCommand(fallbackMethod = "defaultUser")
    public Future<User> getUserByIdAsync(final String id) {

        return new AsyncResult<User>() {
            public User invoke() {
                return restTemplate.getForObject("", User.class, id);
            }
        };
    }

    class User{
        User(){

        }
    }

    protected User defaultUser(){
        return new User();
    }
}
