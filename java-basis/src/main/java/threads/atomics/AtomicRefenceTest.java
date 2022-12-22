package threads.atomics;import jdk.nashorn.internal.objects.annotations.Constructor;import lombok.AllArgsConstructor;import lombok.Data;import lombok.NoArgsConstructor;import java.util.concurrent.atomic.AtomicReference;public class AtomicRefenceTest {    public static AtomicReference<User> atomicReference = new AtomicReference<User>();    public static void main(String[] args) {        User user = new User("conan", 15);        atomicReference.set(user);        User updateUser = new User("shinichi", 17);        atomicReference.compareAndSet(user, updateUser);        System.out.println(atomicReference.get().getName());        System.out.println(atomicReference.get().getOld());    }    @Data    @NoArgsConstructor    @AllArgsConstructor    static class User {        private String name;        private int old;    }}