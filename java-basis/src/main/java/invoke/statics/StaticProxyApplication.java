package invoke.statics;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 11:13
 */

public class StaticProxyApplication {
    public static void main(String[] args) {
        IHelloService iHelloService = new HelloService();
        StaticProxyInvoke staticProxyInvoke = new StaticProxyInvoke(iHelloService);
        staticProxyInvoke.sayHello("wang jia le");
    }
}
