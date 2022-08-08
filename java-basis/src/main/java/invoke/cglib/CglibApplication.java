package invoke.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 16:22
 */

public class CglibApplication {
    public static void main(String[] args) {
        CglibHello cglibHello = new CglibHelloImpl();
        /**
         * 设置产生代理对象的父类，增加类型
         */
        CglibHello helloInterface;
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(CglibHelloImpl.class);
        /**
         * 定义代理逻辑对象为当前对象，要求当前对象实现methodInterceptor 接口
         */
        enhancer.setCallback((Callback) new CglibInterceptor(cglibHello));
        CglibHello cglibHello1 = (CglibHello) enhancer.create();
        cglibHello1.sayHello("shilh");
        cglibHello1.sayByebye("shilh");

        CglibHello cglibHello2 = new CglibHelloImpl();
        CglibInterceptor cglibInterceptor = new CglibInterceptor(cglibHello2);
//        CglibHello cglibHello3  = cglibInterceptor.newProxyInstance(cglibHello2);





    }
}
