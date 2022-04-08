package foundation.modthod;

public class CommandApplication {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreateComand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
