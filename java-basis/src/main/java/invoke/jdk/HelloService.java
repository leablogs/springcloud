package invoke.jdk;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 14:50
 */

public class HelloService implements IHelloService {
    @Override
    public String sayHello(String userName) {
        System.out.println(userName + " hello");
        return userName + " hello";
    }

    @Override
    public String saygoodBay(String userName) {
        System.out.println(userName+ " ByeBye");
        return userName + " ByeBye";
    }
}
