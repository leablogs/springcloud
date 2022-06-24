package com.leablogs.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixObservableCommand;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.apache.catalina.User;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 实现Hystrix命令定义
 */
public class UserHystrixObservableCommand extends HystrixObservableCommand<User> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RestTemplate restTemplate = null;
        //通过 observer和toObservable
        Observable<User> ho = new UserHystrixObservableCommand(null, restTemplate, 1L).observe();
        Observable<User> co = new UserHystrixObservableCommand(null, restTemplate, 1L).toObservable();

    }

    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("CommandKey");
    private RestTemplate restTemplate;
    private Long id;


    protected UserHystrixObservableCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;

    }

    /**
     * 开启请求缓存
     *
     * @return
     */
    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }

    @Override
    protected Observable<User> construct() {
        return Observable.create(new Observable.OnSubscribe<User>() {
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

    public static void flushCache(Long id) {
        // 刷新缓存，根据id进行清理
        HystrixRequestCache.getInstance(GETTER_KEY,
                HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id
        ));
    }
}
