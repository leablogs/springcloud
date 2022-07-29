package invoke.cglib;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 16:48
 */

public interface CglibHello {
    default String sayHello(String userName) {
        return userName;
    }

    public String sayByebye(String userName);
}
