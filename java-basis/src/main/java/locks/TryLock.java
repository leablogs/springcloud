package locks;

import org.apache.catalina.User;
import oshi.annotation.concurrent.GuardedBy;
import oshi.annotation.concurrent.NotThreadSafe;
import oshi.annotation.concurrent.ThreadSafe;

public class TryLock {
    public static void main(String[] args) {
        System.out.println(11%2);
    }
    @ThreadSafe
    synchronized public boolean transferMoney(){
        return false;
    }

    @NotThreadSafe
    public boolean transferMoney1(){
        return false;
    }
    @GuardedBy("this")
    public boolean transferMoney2(){
        return false;
    }
}
