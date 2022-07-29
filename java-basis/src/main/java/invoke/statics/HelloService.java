package invoke.statics;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 11:09
 */

public class HelloService implements IHelloService {
    @Override
    public String sayHello(String userName) {
        System.out.println("Hello service " + userName);
        return "Hello service "+ userName;
    }
}
