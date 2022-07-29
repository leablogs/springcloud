package invoke.cglib;

import lombok.Data;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 16:13
 */
@Data
public class CglibInterceptor implements MethodInterceptor {

    private Object obj;

    CglibInterceptor(Object obj) {
        this.obj = obj;
    }

    /**
     * cglib增强类对象，代理类对象是由enhancer创建
     * 字节码增强器，
     */
    private Enhancer enhancer = new Enhancer();


    /**
     * @param obj
     * @param method
     * @param args
     * @param methodProxy
     * @return cglib 生成用来代替method对象的对象
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法调用前");
        Object o = methodProxy.invokeSuper(obj, args);
        System.out.println("方法调用之后");
        return o;
    }

    public Object newProxyInstance(Class<?> c) {
        /**
         * 设置产生代理对象的父类，增加类型
         */
        enhancer.setSuperclass(c);
        /**
         * 定义代理逻辑对象为当前对象，要求当前对象实现methodInterceptor 接口
         */
        enhancer.setCallback(this);
        return enhancer.create();
    }


}
