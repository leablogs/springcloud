package invoke.cglib;

/**
 * @description
 * @author: shilh
 * @time 2022/7/13 16:10
 */

public class CglibHelloImpl implements CglibHello {
    public String sayHello(String userName){
        System.out.println("目标对象方法执行=============");
        return userName + "sayHello";
    }

    public String sayByebye(String userName){
        System.out.println("目标对象方法执行==============");
        return userName + "Byebye";
    }
}
