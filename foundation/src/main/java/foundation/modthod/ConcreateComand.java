package foundation.modthod;

public class ConcreateComand implements Command {
    private Receiver receiver = null;

    public ConcreateComand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
