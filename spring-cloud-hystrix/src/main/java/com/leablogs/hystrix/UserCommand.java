package com.leablogs.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommandResponseFromCache;
import rx.Observable;
import org.apache.catalina.User;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 实现Hystrix命令定义
 */
public class UserCommand extends HystrixCommand<User> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RestTemplate restTemplate = null;
        // 传统调用
        User u = new UserCommand(null, restTemplate, 1L).execute();
        Future<User> future = new UserCommand(null, restTemplate, 1L).queue();
        future.get();
        //通过 observer和toObservable
        Observable<User> ho = new UserCommand(null, restTemplate, 1L).observe();
        Observable<User> co = new UserCommand(null, restTemplate, 1L).toObservable();

    }

    private RestTemplate restTemplate;
    private Long id;


    protected UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
//        super(setter);
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(500))
        );
        this.restTemplate = restTemplate;
        this.id = id;

    }


    @Override
    protected User run() throws Exception {
        restTemplate.getForObject("", User.class, id);
        return null;
    }
}
