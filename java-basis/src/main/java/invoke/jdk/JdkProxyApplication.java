package invoke.jdk;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 15:04
 */

public class JdkProxyApplication {
    public static void main(String[] args) {
        IHelloService iHelloService = new HelloService();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler(iHelloService);
        IHelloService helloService = (IHelloService) proxyInvocationHandler.newProxyInstance();
        helloService.sayHello("shilihui");
        helloService.saygoodBay("shilh");
    }
}























