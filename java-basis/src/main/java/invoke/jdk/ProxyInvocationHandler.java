package invoke.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 14:52
 */

public class ProxyInvocationHandler implements InvocationHandler {
    /**
     * 中间类持有委托对象引用，
     */
    private Object obj;

    /**
     * 传入委托类对象
     *
     * @param obj
     */
    ProxyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    public Object newProxyInstance() {
        return Proxy.newProxyInstance(
                //指定类加载器
                obj.getClass().getClassLoader(),
                // 指定代理对象实现的接口，可以指定多个接口
                obj.getClass().getInterfaces(), this
        );
    }

    /**
     * @param proxy  代理对象
     * @param method 代理方法
     * @param args   代理参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before");
        Object result = method.invoke(obj, args);
        System.out.println("invoke after");
        return result;
    }
}
