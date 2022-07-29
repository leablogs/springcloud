package invoke.statics;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 10:44
 */

public class StaticProxyInvoke implements IHelloService {
    private IHelloService iHelloService;

    StaticProxyInvoke(IHelloService iHelloService){
        this.iHelloService=iHelloService;
    }

    @Override
    public String sayHello(String userName) {
        System.out.println("代理对象包装盒子：" + userName);
        return iHelloService.sayHello(userName);
    }
}
